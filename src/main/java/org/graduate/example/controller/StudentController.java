package org.graduate.example.controller;

import lombok.RequiredArgsConstructor;
import org.graduate.example.service.StudentService;
import org.graduate.example.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/student/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    //展示所有导师
    @GetMapping("teachers")
    public Mono<ResultVO> listTeachers(@RequestAttribute String depId){
        return studentService.ListTeacher(depId).map(ResultVO::success);
    }

}
