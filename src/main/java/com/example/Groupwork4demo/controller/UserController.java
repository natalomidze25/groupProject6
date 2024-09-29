package com.example.Groupwork4demo.controller;

import com.example.Groupwork4demo.dto.UserDto;
import com.example.Groupwork4demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public void register(@RequestBody UserDto dto){
        userService.registerUser(dto);
    }

    @GetMapping("")
    public ResponseEntity getAll(){
       return new ResponseEntity<>(userService.userDtoList(), HttpStatus.OK) ;
    }
}
