package org.graduate.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.graduate.example.Repository.ProcessRepository;
import org.graduate.example.Repository.ScoreRepository;
import org.graduate.example.Repository.UserRepository;
import org.graduate.example.dox.User;
import org.graduate.example.service.StudentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final UserRepository userRepository;
    private final ProcessRepository processRepository;
    private final ScoreRepository scoreRepository;


    //查看所有导师
    public Mono<List<User>> ListTeacher(String depId){
        return userRepository.findByDepIdAndRole(depId,User.ROLE_TEACHER).collectList();
    }
    //选择导师
    public Mono<Void> chooseMentor(String sid,String tid){
        return userRepository.updateStudentById(sid, tid);
    }
}
