package org.graduate.example.Service.impl;

import lombok.Builder;
import org.graduate.example.dox.Department;
import org.graduate.example.dox.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@Builder
class AdminServiceImplTest {

    @Test
    void addDepartment() {
        Department department = Department.builder().name("软甲工程").build();
    }

    @Test
    void listDepartment() {
    }

    @Test
    void delDepartment() {
    }

    @Test
    void addUser() {
        User uesr = User.builder().account("2022212829").role("student").build();

    }

    @Test
    void allUsers() {
    }

    @Test
    void initPassword() {
    }

    @Test
    void testAddDepartment() {
    }

    @Test
    void testListDepartment() {
    }

    @Test
    void testDelDepartment() {
    }

    @Test
    void testAddUser() {
    }

    @Test
    void testAllUsers() {
    }

    @Test
    void testInitPassword() {
    }
}