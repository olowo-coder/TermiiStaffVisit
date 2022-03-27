package com.example.termiistaffvisitor.service;

import com.example.termiistaffvisitor.dto.UserDto;
import com.example.termiistaffvisitor.model.User;

public interface UserService {
    
    UserDto register(UserDto userDto);

    UserDto login(UserDto userDto);
}
