package org.graduate.example.Repository;

import lombok.extern.slf4j.Slf4j;
import org.graduate.example.dox.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DepartmentRepositoryTest {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void save(){
//        Department department = Department.builder().name("人工智能").build();
//        Department department1 = Department.builder().name("大数据").build();
//        Department department2 = Department.builder().name("计算机科学与技术").build();
//        Department department3 = Department.builder().name("软件工程").build();
        Department department4 = Department.builder().name("管理").build();

//        departmentRepository.save(department1).block();
//        departmentRepository.save(department2).block();
//        departmentRepository.save(department3).block();
        departmentRepository.save(department4).block();
    }
    @Test
    void findByName() {
    }
}