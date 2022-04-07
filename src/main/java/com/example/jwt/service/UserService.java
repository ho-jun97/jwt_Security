package com.example.jwt.service;

import com.example.jwt.domain.user.User;
import com.example.jwt.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public String save(User user){
        userRepository.save(user);
        return "회원가입완료";
    }
}
