package org.graduate.example.service;

import lombok.RequiredArgsConstructor;
import org.graduate.example.Repository.DepartmentRepository;
import org.graduate.example.Repository.UserRepository;
import org.graduate.example.dox.Department;
import org.graduate.example.dox.User;
import org.graduate.example.dto.Code;
import org.graduate.example.exception.XException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public interface AdminService {


    //    添加专业
    public Mono<Void> addDepartment(Department department);
    //查看所有的专业
    public Mono<List<Department>> listDepartment();
    //删除空的专业
    @Transactional
    public Mono<Void> delDepartment(String did);
    //添加用户
    public Mono<Void> addUser(User user);
    //查看所有用户
    public Mono<List<User>> allUsers();
    //初始化加密密码(管理员)
    public Mono<Void> initPassword(String account);

}
