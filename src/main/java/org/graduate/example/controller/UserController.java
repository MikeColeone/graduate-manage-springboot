package org.graduate.example.controller;
import lombok.RequiredArgsConstructor;
import org.graduate.example.vo.ResultVO;
import org.graduate.example.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("processes")
    public Mono<ResultVO> processList(@RequestAttribute String depId){
        return userService.listProcess(depId).
                map(ResultVO::success);
    }

    @GetMapping("users")
    public Mono<ResultVO> userList(){
        return userService.listUser("1","1")
                .map(ResultVO::success);
    }

    @PatchMapping("reset")
    public Mono<ResultVO> resetPassword(@RequestAttribute String uid,@RequestBody String newPassword){
        return userService.resetPassword(uid,newPassword).thenReturn(ResultVO.ok());
    }
}