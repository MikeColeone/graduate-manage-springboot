package org.graduate.example.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.graduate.example.dox.User;
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

@Component
@Slf4j
@Order(2)
@RequiredArgsConstructor
public class TeacherFilter implements WebFilter {
    private final ResponseHelper responseHelper;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        PathPattern includes = new PathPatternParser().parse("/api/teacher/**");
        ServerHttpRequest request = exchange.getRequest();
        if(includes.matches(request.getPath().pathWithinApplication())){
            String role=exchange.getAttribute(RequestAttributeConstant.ROLE);
            if(User.ROLE_TEACHER.equals(role)){
                return chain.filter(exchange);
            }
            return responseHelper.response(Code.FORBIDDEN,exchange);
        }
        return chain.filter(exchange);
    }
}
