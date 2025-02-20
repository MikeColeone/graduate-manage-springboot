package org.graduate.example.Service;

import lombok.extern.slf4j.Slf4j;
import org.graduate.example.component.JWTComponent;
import org.graduate.example.dto.Login;
import org.graduate.example.service.UserService;
import org.graduate.example.vo.ResultVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
public class LoginTest {
    @Autowired
    private UserService userService;

    @Autowired
    private JWTComponent jwtComponent;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    void login(){
        Login login=Login.builder()
                .account("1")
                .password("1")
                .build();
        //String token = jwtComponent.encode(Map.of("uid", user.getId(), "role", user.getRole(), "department", user.getDepartment(), "group", user.getGroup()));
        userService.getUser(login.getAccount())
                    .filter(u -> passwordEncoder.matches(login.getPassword(), u.getPassword()))
                .map(ResultVO::success
                ).doOnNext(resultVO -> log.info("{}",resultVO)).block();

    }
}
