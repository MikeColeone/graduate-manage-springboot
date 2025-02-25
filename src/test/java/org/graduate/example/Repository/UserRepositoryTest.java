package org.graduate.example.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.graduate.example.dox.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RequiredArgsConstructor
@Slf4j
@SpringBootTest
class UserRepositoryTest {


    public static final String ROLE_STUDENT = "qpCf";
    public static final String ROLE_TEACHER = "kU4T";
    public static final String ROLE_ADMIN = "R2md";
    @Autowired
    private UserRepository userRepository;
    @Test
//    void save() {
//        User user = User.builder()
//                .account("2022212829")
//                .password("2022212829")
//                .role("R2md")
//                .name("Hedx")
//                .build(); // 不手动设置 departmentId
//
//        userRepository.save(user)
//                .doOnSuccess(savedUser -> log.info("Saved user: {}", savedUser))
//                .block();
//    }

//    void save() {
//        User user = User.builder()
//                .account("2022212828")
//                .password("2022212828")
//                .role("R2md")
//                .name("He")
//                .build(); // 不手动设置 departmentId
//
//        userRepository.save(user)
//                .doOnSuccess(savedUser -> log.info("Saved user: {}", savedUser))
//                .block();
//    }

    void save(){


            List<String> departments = Arrays.asList(
                    "1343531568", // 软件工程
                    "1343534645", // 计算机科学与技术
                    "1343534698", // 大数据
                    "1343534742"  // 人工智能
            );

            List<String> roles = Arrays.asList(ROLE_STUDENT, ROLE_TEACHER, ROLE_ADMIN);

            int i  = 0;

            String account;
            for (String departmentId : departments) {

                for (String role : roles) {
                    if(i<10) {
                        account = 202221221 + "1" + i;
                    }
                    else {
                        account = 202221221 + "2" + i;
                    }
                        i++;
                        User user = User.builder()
                                .account(account)
                                .password(account) // 初始密码与账号相同
                                .role(role)
                                .department(departmentId)
                                .name("He")
                                .build();
                        System.out.println(user);
                        userRepository.save(user).block();
                    }
                }
    }



    @Test
    void findByAccount() {
        String account = "2022212829";
        userRepository.findByAccount(account).subscribe();
        log.info(userRepository.findByAccount(account).toString());
    }

    @Test
    void updatePasswordById() {
    }

    @Test
    void updatePasswordByAccount() {
    }

    @Test
    void countByDepartment() {
    }

    @Test
    void findByDepIdAndRole() {
    }

    @Test
    void findByDepIdAndRoleAndGroup() {
    }

    @Test
    void mentorStudents() {
    }

    @Test
    void updateStudentById() {
    }
}