package org.graduate.example.service;


import org.graduate.example.dox.Process;
import org.graduate.example.dox.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public interface UserService {

//    void init();

    //登录时拿user
    public Mono<User> getUser(String account);
    //根据depId和role查看user
    public Mono<List<User>> listUser(String depId,String role);

    public Mono<Object> listProcess(String depId);
    public Flux<Process> listProcess2(String depId);
    //修改密码
    public Mono<Void> resetPassword(String uid,String newPassword);
}
