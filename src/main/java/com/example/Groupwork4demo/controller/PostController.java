package com.example.Groupwork4demo.controller;

import com.example.Groupwork4demo.dto.PostDto;
import com.example.Groupwork4demo.security.JwtUtils;
import com.example.Groupwork4demo.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("post")
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping
        public void createPost( @RequestBody PostDto dto, HttpServletRequest request){
        postService.createPost(dto,jwtUtils.getUserNameFromRequest(request));

    }

    @DeleteMapping
    public void deletePost(@RequestParam long id, HttpServletRequest request){
        postService.deletePost(id,  jwtUtils.getUserNameFromRequest(request));

    }

    @PutMapping
    public void updatePost(
                           @RequestBody PostDto dto, HttpServletRequest request){

        postService.updatePost(dto,  jwtUtils.getUserNameFromRequest(request));
    }

    @GetMapping
    public  PostDto getPostByID(@RequestParam Long id, HttpServletRequest request){
        return postService.getById(id, jwtUtils.getUserNameFromRequest(request));
    }

    @GetMapping("getUserPosts")
    public List<PostDto> getUserPosts(
                                      @RequestParam Long pageNumber,
                                      @RequestParam Long pageSize, HttpServletRequest request){
        return postService.getUserAllPost(pageNumber,pageSize, jwtUtils.getUserNameFromRequest(request));
    }

    @GetMapping("getAllPosts")
    public List<PostDto> getAllPosts(
                                      @RequestParam Long pageNumber,
                                      @RequestParam Long pageSize, HttpServletRequest request){
        return postService.getAllPost(pageNumber,pageSize, jwtUtils.getUserNameFromRequest(request));
    }

}
