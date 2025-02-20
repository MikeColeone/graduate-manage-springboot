package org.graduate.example.Service;

import lombok.extern.slf4j.Slf4j;
import org.graduate.example.service.UserService;
import org.graduate.example.vo.ResultVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void getUser(){
//        userService.getUser("1").doOnNext(user -> log.info("{}",user)).block();


        userService.getUser("1")
                .map(ResultVO::success)
                .doOnNext(resultVO -> log.info("{}",resultVO))
                .block();
    }
}
