package com.better_notes.server.service.interfaces;

import com.better_notes.server.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
}
