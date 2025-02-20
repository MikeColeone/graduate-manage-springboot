package org.graduate.example.service;


import org.graduate.example.dox.User;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StudentService {

    //查看所有导师
    public Mono<List<User>> ListTeacher(String depId);
    //选择导师
    public Mono<Void> chooseMentor(String sid,String tid);
}
