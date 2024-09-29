package com.example.Groupwork4demo.controller;

import com.example.Groupwork4demo.dto.PostDto;
import com.example.Groupwork4demo.model.User;
import com.example.Groupwork4demo.service.PostService;
import com.example.Groupwork4demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("post")
@RestController
public class PostController {

    @Autowired
    private PostService postService;




    @PostMapping
        public void createPost(@RequestParam String userName,@RequestBody PostDto dto){

        postService.createPost(dto,userName);

    }

    @DeleteMapping
    public void deletePost(@RequestParam String userName,@RequestParam long id){
        postService.deletePost(id, userName);

    }

    @PutMapping
    public void updatePost(@RequestParam String userName,
                           @RequestBody PostDto dto){

        postService.updatePost(dto, userName);
    }

    @GetMapping
    public  PostDto getPostByID(@RequestParam String userName,@RequestParam Long id){
        return postService.getById(id, userName);
    }

    @GetMapping("getUserPosts")
    public List<PostDto> getUserPosts(@RequestParam String userName,
                                      @RequestParam Long pageNumber,
                                      @RequestParam Long pageSize){
        return postService.getUserAllPost(pageNumber,pageSize,userName);
    }

    @GetMapping("getAllPosts")
    public List<PostDto> getAllPosts(@RequestParam String userName,
                                      @RequestParam Long pageNumber,
                                      @RequestParam Long pageSize){
        return postService.getAllPost(pageNumber,pageSize, userName);
    }

}
