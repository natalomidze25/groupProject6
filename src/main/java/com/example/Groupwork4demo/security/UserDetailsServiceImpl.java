package com.example.Groupwork4demo.security;

import com.example.Groupwork4demo.model.User;
import com.example.Groupwork4demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service(value = "userService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }

        return UserDetailsImpl.build(user);
    }

}
