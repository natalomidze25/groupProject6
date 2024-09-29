package com.example.Groupwork4demo.service;

import com.example.Groupwork4demo.dto.UserDto;
import com.example.Groupwork4demo.exception.GeneralException;
import com.example.Groupwork4demo.model.User;
import com.example.Groupwork4demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User findByUserName(String userName){
        User user = userRepository.findByUserName(userName);
        if(user == null){
            throw new GeneralException("user not found", HttpStatus.BAD_REQUEST);
        }
        return user;
    }

    public List<UserDto> userDtoList(){
        return userRepository.findAll().stream().map(x->new UserDto(x)).collect(Collectors.toList());
    }
    public void registerUser(UserDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setDateOfBirth(dto.getDateOfBirth());
        userRepository.save(user);
    }
}
