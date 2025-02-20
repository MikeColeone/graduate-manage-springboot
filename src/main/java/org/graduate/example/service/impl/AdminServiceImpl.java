package org.graduate.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.graduate.example.Repository.DepartmentRepository;
import org.graduate.example.Repository.UserRepository;
import org.graduate.example.dox.Department;
import org.graduate.example.dox.User;
import org.graduate.example.dto.Code;
import org.graduate.example.exception.XException;
import org.graduate.example.service.AdminService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // 添加专业
    @Transactional
    public Mono<Void> addDepartment(Department department){
        return departmentRepository.save(department).then();
    }
    //查看所有的专业
    public Mono<List<Department>> listDepartment(){
        return departmentRepository.findAll().collectList();
    }
    //删除空的专业
    @Transactional
    public Mono<Void> delDepartment(String did){
        return userRepository.countByDepartment(did)
                .flatMap(userCount->{
                    if(userCount>0)return Mono.error(XException.builder().codeN(Code.ERROR).message("部门包含用户禁止删除").build());
                    return departmentRepository.deleteById(did).then();
                });
    }

    //用户

    @Transactional
    //添加用户
    public Mono<Void> addUser(User user) {
        return userRepository.save(user).then();
    }
    //查看所有用户
    public Mono<List<User>> allUsers(){
        return userRepository.findAll().collectList();
    }

    //初始化加密密码(管理员)
    public Mono<Void> initPassword(String account){
        String encodePassword=passwordEncoder.encode(account);
        return userRepository.updatePasswordByAccount(account,encodePassword).then();
    }

}
