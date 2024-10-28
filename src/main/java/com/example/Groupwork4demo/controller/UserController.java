package com.example.Groupwork4demo.controller;

import com.example.Groupwork4demo.dto.LoginRequest;
import com.example.Groupwork4demo.dto.UserDto;
import com.example.Groupwork4demo.security.JwtResponse;
import com.example.Groupwork4demo.security.JwtUtils;
import com.example.Groupwork4demo.service.UserServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserServiceCustom userService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest){
        JwtResponse response = jwtUtils.getToken(loginRequest.getUsername(),loginRequest.getPassword());
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PostMapping("register")
    public void register(@RequestBody UserDto dto){
        userService.registerUser(dto);
    }

}
