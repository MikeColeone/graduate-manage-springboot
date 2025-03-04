package org.graduate.example.controller;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.graduate.example.component.JWTComponent;
import org.graduate.example.dto.Code;
import org.graduate.example.dto.LoginDto;
import org.graduate.example.vo.ResultVO;
import org.graduate.example.service.UserService;
import org.graduate.example.vo.RequestAttributeConstant;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTComponent jwtComponent;
    @PostMapping("login")
    public Mono<ResultVO> login(@RequestBody LoginDto login, ServerHttpResponse resp) {
        System.out.println("=========================================================================");
        log.info("login : {}", login);
        System.out.println(userService.getUser(login.getAccount()).block());
        return userService.getUser(login.getAccount())
                .doOnNext(user -> log.info("查询到用户: {}", user))
                .filter(u -> passwordEncoder.matches(login.getPassword(), u.getPassword()))
                .map(user -> {
                    String token = jwtComponent.encode(Map.of(
                            RequestAttributeConstant.UID, user.getId(),
                            RequestAttributeConstant.ROLE, user.getRole(),
                            RequestAttributeConstant.DEPARTMENT_ID, user.getDepartment(),
                            RequestAttributeConstant.GROUP_NUMBER, user.getGroupNumber()
                    ));

                    resp.getHeaders().add(RequestAttributeConstant.TOKEN, token);
                    resp.getHeaders().add(RequestAttributeConstant.ROLE, user.getRole());
                    log.debug("{}", user);
                    log.info("Response Headers: {}", resp.getHeaders());

                    return ResultVO.success(user);
                })
                .defaultIfEmpty(ResultVO.error(Code.LOGIN_ERROR));
    }

}
