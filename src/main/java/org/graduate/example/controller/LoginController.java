package org.graduate.example.controller;



import lombok.RequiredArgsConstructor;
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

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTComponent jwtComponent;
    @PostMapping("login")
    public Mono<ResultVO> login(@RequestBody LoginDto login, ServerHttpResponse resp){
        return userService.getUser(login.getAccount())
                .filter(u->passwordEncoder.matches(login.getPassword(),u.getPassword()))
                .map(user -> {
                    String token=jwtComponent.encode(Map.of("uid", user.getId(), "role", user.getRole(),"department",user.getDepartment(),"group",user.getGroupNumber()));
                    resp.getHeaders().add(RequestAttributeConstant.TOKEN,token);
                    resp.getHeaders().add(RequestAttributeConstant.ROLE,user.getRole());
                    return ResultVO.success(user);}
                ).defaultIfEmpty(ResultVO.error(Code.LOGIN_ERROR));
    }

    @GetMapping("test")
    public Mono<ResultVO> test(@RequestAttribute String depId, @RequestAttribute String role, @RequestAttribute String uid)
    {
        StringBuilder result=new StringBuilder("depId->>").append(depId).append("  ")
                .append("role->>").append(role).append("  ")
                .append("uid->>").append(uid);

        return Mono.just(ResultVO.success(result));
    }
}
