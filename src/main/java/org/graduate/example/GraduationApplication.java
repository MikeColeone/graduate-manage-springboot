package org.graduate.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GraduationApplication {

    public static void main(String[] args) {

        System.out.println("应用启动");
        SpringApplication.run(GraduationApplication.class, args);
    }

}
