package com.example.Groupwork4demo.service;

import com.example.Groupwork4demo.dto.PostDto;
import com.example.Groupwork4demo.model.Post;
import com.example.Groupwork4demo.model.User;
import com.example.Groupwork4demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private UserServiceCustom userService;
    @Autowired
    private PostRepository postRepository;

    public void createPost(PostDto postDto, String userName) {
        User user = userService.findByUserName(userName);

        Post post = new Post();
        post.setCreatorUsersName(user);
        post.setText(postDto.getText());
        postRepository.save(post);
    }

    public void deletePost(Long id, String userName) {
        User user = userService.findByUserName(userName);

        Post post = postRepository.findById(id).get();
        postRepository.delete(post);
    }

    public void updatePost(PostDto postDto, String userName) {
        User user = userService.findByUserName(userName);

        Post post = postRepository.findById(postDto.getId()).get();
        post.setText(postDto.getText());
        postRepository.save(post);
    }

    public List<PostDto> getAllPost(Long pageNumber, Long pageSize, String userName) {
        User user = userService.findByUserName(userName);

        return postRepository.findAll().stream()
                .skip(pageSize * pageNumber)
                .limit(pageSize)
                .map(PostDto::new).collect(Collectors.toList());
    }

    public List<PostDto> getUserAllPost(Long pageNumber, Long pageSize, String userName) {
        User user = userService.findByUserName(userName);

        return postRepository.getAllByUser(user).stream()
                .skip( pageSize * pageNumber)
                .limit(pageSize)
                .map(PostDto::new).collect(Collectors.toList());
    }

    public PostDto getById(Long id, String userName){
        User user = userService.findByUserName(userName);

        return new PostDto(postRepository.findById(id).get());
    }
}
