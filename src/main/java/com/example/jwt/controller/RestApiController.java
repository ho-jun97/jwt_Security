package com.example.jwt.controller;

import com.example.jwt.domain.user.User;
import com.example.jwt.domain.user.UserRepository;
import com.example.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestApiController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;


    @PostMapping("token")
    public String token(){
        return "<h1>token</h1>";
    }

    @PostMapping("join")
    public String join(@RequestBody User user){
        user.setPwd(bCryptPasswordEncoder);
        user.userRole();
        String ans = userService.save(user);
        return ans;
    }
    @PostMapping("adminJoin")
    public String adminJoin(@RequestBody User user){
        user.setPwd(bCryptPasswordEncoder);
        user.adminRole();
        userService.save(user);
        return "회원가입완료";
    }
    // user, manager, admin
    @GetMapping("/api/v1/user")
    public String user(){
        return "user";
    }
    // manager, admin
    @GetMapping("/api/v1/manager")
    public String manager(){
        return "manager";
    }
    // admin
    @GetMapping("/api/v1/admin")
    public String admin(){
        return "amdin";
    }
}
