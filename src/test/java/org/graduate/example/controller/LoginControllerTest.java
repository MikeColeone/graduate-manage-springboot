package org.graduate.example.controller;

import org.graduate.example.component.JWTComponent;
import org.graduate.example.dox.User;
import org.graduate.example.dto.Code;
import org.graduate.example.dto.LoginDto;
import org.graduate.example.filter.ResponseHelper;
import org.graduate.example.service.UserService;
import org.graduate.example.vo.ResultVO;
import org.graduate.example.vo.RequestAttributeConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;

@WebFluxTest(LoginController.class)
class LoginControllerTest {

    @MockBean
    private ResponseHelper responseHelper;

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UserService userService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private JWTComponent jwtComponent;

    @BeforeEach
//    void setUp() {
//        // 模拟用户数据
//        User user = User.builder()..build();
//
//
//        // 模拟 UserService 返回数据
//        Mockito.when(userService.getUser("testuser")).thenReturn(Mono.just(user));
//
//        Mockito.when(passwordEncoder.matches("testpassword", "encodedPassword")).thenReturn(true);
//
//        Mockito.when(jwtComponent.encode(any(Map.class))).thenReturn("mocked-jwt-token");
//    }

    @Test
    public void testLoginSuccess() {
        webTestClient.post().uri("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"account\":\"2022212829\",\"password\":\"2022212829\"}")
                .exchange().expectStatus().isOk();
    }


    @Test
    void testLoginFailure() {
        LoginDto loginDto = new LoginDto();
        loginDto.setAccount("2022212829");
        loginDto.setPassword("2022212829");

        // 模拟密码匹配失败
        Mockito.when(passwordEncoder.matches("wrongpassword", "encodedPassword")).thenReturn(false);

        webTestClient.post()
                .uri("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(loginDto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ResultVO.class)
                .consumeWith(response -> {
                    ResultVO result = response.getResponseBody();
                    assert result != null;
                });
    }
}
