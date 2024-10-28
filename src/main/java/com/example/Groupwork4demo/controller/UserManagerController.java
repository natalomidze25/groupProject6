package com.example.Groupwork4demo.controller;

import com.example.Groupwork4demo.security.JwtResponse;
import com.example.Groupwork4demo.security.JwtUtils;
import com.example.Groupwork4demo.service.UserServiceCustom;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user-manager")
@RestController
public class UserManagerController {
    @Autowired
    private UserServiceCustom userService;

    @Autowired
    private JwtUtils jwtUtils;


    @GetMapping("")
    public ResponseEntity getAll(){
        return new ResponseEntity<>(userService.userDtoList(), HttpStatus.OK) ;
    }

    @GetMapping("refresh-token")
    public JwtResponse refreshToken(HttpServletRequest request){

        return jwtUtils.getTokenRefresh(userService.findByUserName(jwtUtils.getUserNameFromRequest(request)));
    }
}
