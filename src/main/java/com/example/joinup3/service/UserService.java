package com.example.joinup3.service;

import com.example.joinup3.entity.User;
import com.example.joinup3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 모든 유저 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ID로 유저 조회
    public User getUserById(String id) {
        return userRepository.findById(id);
    }

    // 새로운 유저 생성
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 유저 삭제
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

}
