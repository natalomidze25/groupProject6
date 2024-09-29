package com.example.Groupwork4demo.service;


import com.example.Groupwork4demo.dto.CommentDto;
import com.example.Groupwork4demo.model.Comment;
import com.example.Groupwork4demo.model.User;
import com.example.Groupwork4demo.repository.CommentRepository;
import com.example.Groupwork4demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private UserService userService;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    public void createComment(CommentDto commentDto, String userName){
        User user = userService.findByUserName(userName);

        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setPost(postRepository.findById(commentDto.getPostId()).get());
        comment.setAuthor(user);
        commentRepository.save(comment);
    }
    public void deleteComment(Long id, String userName){
        User user = userService.findByUserName(userName);

        Comment comment = commentRepository.findById(id).get();
        commentRepository.delete(comment);

    }
    public void updateComment(CommentDto commentDto, String userName){
        User user = userService.findByUserName(userName);

        Comment comment = commentRepository.findById(commentDto.getId()).get();
        comment.setText(commentDto.getText());
        commentRepository.save(comment);
    }

    public List<CommentDto> getComment(String userName){
        User user = userService.findByUserName(userName);

        return commentRepository.findAll().stream().map(CommentDto::new).collect(Collectors.toList());
    }
}
