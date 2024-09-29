package com.example.Groupwork4demo.service;

import com.example.Groupwork4demo.dto.ReqresDto;
import com.example.Groupwork4demo.model.User;
import com.example.Groupwork4demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class StartupService {

    @Autowired
    private UserRepository userRepository;


    @EventListener(ApplicationReadyEvent.class)
     public void callService(){
         try {
             HttpClient client = HttpClient.newHttpClient();
             HttpRequest request = HttpRequest.newBuilder()
                     .uri(URI.create("https://reqres.in/api/users"))
                     .build();
             HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
             ObjectMapper mapper = new ObjectMapper();
             ReqresDto reqresDto = mapper.readValue(response.body(), ReqresDto.class);
             reqresDto.getData().forEach(x->{
                 User user  = userRepository.findOptionalByUserName(x.getEmail()).orElse(new User()) ;
                 user.setUsername(x.getEmail());
                 user.setLastName(x.getLast_name());
                 user.setFirstName(x.getFirst_name());
                 userRepository.save(user);
             });
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

}
