package org.graduate.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // 关闭 CSRF 保护
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()  // 允许访问登录 API
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
