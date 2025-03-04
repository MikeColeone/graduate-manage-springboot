package org.graduate.example.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.graduate.example.component.JWTComponent;
import org.graduate.example.dox.Department;
import org.graduate.example.dto.Code;
import org.graduate.example.vo.RequestAttributeConstant;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
@Order(1)
@RequiredArgsConstructor
public class LoginFilter implements WebFilter {

    private final PathPattern includes=new PathPatternParser().parse("/api/**");
    private final List<PathPattern> excludes=List.of(new PathPatternParser().parse("/api/login"));
    private final JWTComponent jwtComponent;
    private final ResponseHelper responseHelper;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        log.info("过滤器处理请求");
        System.out.println("login过滤器执行了");
        ServerHttpRequest request = exchange.getRequest();
        if (!includes.matches(request.getPath().pathWithinApplication())) {
            System.out.println("不在范围里跳过");
            return chain.filter(exchange);
        }

        //流式
        if(excludes.stream().anyMatch(p->p.matches(request.getPath().pathWithinApplication()))) return chain.filter(exchange);

        String token=request.getHeaders().getFirst(RequestAttributeConstant.TOKEN);
        if(token==null) {
            log.info("token is null");
            return responseHelper.response(Code.UNAUTHORIZED,exchange);
        }

        return jwtComponent.decode(token).flatMap(decode -> {
            exchange.getAttributes().put(RequestAttributeConstant.UID, decode.getClaim(RequestAttributeConstant.UID).asString());
            exchange.getAttributes().put(RequestAttributeConstant.ROLE, decode.getClaim(RequestAttributeConstant.ROLE).asString());
            try {
                Department department = objectMapper.readValue(decode.getClaim("department").asString(), Department.class);
                exchange.getAttributes().put(RequestAttributeConstant.DEPARTMENT_ID,department.getDepId());
            } catch (JsonProcessingException e) {
                return Mono.error(new RuntimeException(e));
            }
            return chain.filter(exchange);
        });

    }
}
