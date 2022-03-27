package com.example.termiistaffvisitor.controller;

import com.example.termiistaffvisitor.dto.UserDto;
import com.example.termiistaffvisitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody final UserDto userDto){
        return new ResponseEntity<>(userService.register(userDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody final UserDto userDto){
        return new ResponseEntity<>(userService.login(userDto), HttpStatus.OK);
    }

}
