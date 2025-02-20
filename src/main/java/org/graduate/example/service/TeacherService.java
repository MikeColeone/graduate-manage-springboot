package org.graduate.example.service;


import org.graduate.example.dox.Process;
import org.graduate.example.dox.Score;
import org.graduate.example.dox.User;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TeacherService {

    //添加过程
    public Mono<Process> addProcess(Process process);
    //删除过程
    public Mono<Void> removeProcess(String pid,String did);
    //查看过程的在userService里
    public Mono<Score> addScore(Score score);
    //为空时保存，不为空更新
    public Mono<Score> updateDetailScore(Score score);
    //查看自己组学生的得分
    public Mono<List<Score>> scoreGroup(int group);
    //查看自己打的分
    public Mono<List<Score>> scoreBy(String tid);

    //用户
    //查看专业所有学生
    public Mono<List<User>> studentList(String depId);

    //查看自己组的学生
    public Mono<List<User>> groupStudents(String depId,int group);
    //自己辅导的学生
    public Mono<List<User>> mentorStudents(String depId,String tid);

}
