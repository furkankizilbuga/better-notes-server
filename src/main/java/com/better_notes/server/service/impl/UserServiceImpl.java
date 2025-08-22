package com.better_notes.server.service.impl;

import com.better_notes.server.dto.user.UserResponseDto;
import com.better_notes.server.entity.User;
import com.better_notes.server.mapper.UserMapper;
import com.better_notes.server.repository.UserRepository;
import com.better_notes.server.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserMapper.toResponseDtoList(users);
    }
}
