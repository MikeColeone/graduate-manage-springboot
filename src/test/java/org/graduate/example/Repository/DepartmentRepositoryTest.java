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
        Department department = Department.builder().name("人工智能").build();

        departmentRepository.save(department).block();
    }
    @Test
    void findByName() {
    }
}