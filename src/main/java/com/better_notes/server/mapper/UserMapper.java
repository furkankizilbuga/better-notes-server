package com.better_notes.server.mapper;

import com.better_notes.server.dto.user.UserInsertDto;
import com.better_notes.server.dto.user.UserResponseDto;
import com.better_notes.server.dto.user.UserUpdateDto;
import com.better_notes.server.entity.User;

import java.util.List;

public class UserMapper {
    public static UserResponseDto toResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static List<UserResponseDto> toResponseDtoList(List<User> users) {
        return users.stream().map(UserMapper::toResponseDto).toList();
    }
}
