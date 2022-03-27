package com.example.termiistaffvisitor.service.serviceImpl;

import com.example.termiistaffvisitor.dto.UserDto;
import com.example.termiistaffvisitor.model.User;
import com.example.termiistaffvisitor.repository.UserRepository;
import com.example.termiistaffvisitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto register(UserDto userDto) {
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()){
            return UserDto.builder().message("Username already registered").build();
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return UserDto.builder().message("Registered successfully").build();
    }

    @Override
    public UserDto login(UserDto userDto) {
        Optional<User> user = userRepository.findByUsername(userDto.getUsername());

        if (user.isEmpty()){
            return UserDto.builder().message("Username not found").build();
        }
        if(!user.get().getPassword().equals(userDto.getPassword())){
            return UserDto.builder().message("Incorrect password").build();
        }
       return UserDto.builder().message("Successfully Login").build();
    }
}
