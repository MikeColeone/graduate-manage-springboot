package org.graduate.example.Service;

import lombok.extern.slf4j.Slf4j;
import org.graduate.example.component.JWTComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TokenTest {

    @Autowired
    private JWTComponent jwtComponent;

    @Test
    void tokenTest(){
    }
}
