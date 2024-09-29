package com.example.Groupwork4demo.controller;

import com.example.Groupwork4demo.dto.CommentDto;
import com.example.Groupwork4demo.model.User;
import com.example.Groupwork4demo.service.CommentService;
import com.example.Groupwork4demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("comment")
@RestController
public class CommentController {
    @Autowired
     private CommentService commentService;

    @PostMapping
    public void createComment(@RequestParam String userName,@RequestBody CommentDto dto){
        commentService.createComment(dto,userName);

    }

    @DeleteMapping
    public void deleteComment(@RequestParam String userName,@RequestParam Long id){

        commentService.deleteComment(id, userName);
    }


    @PutMapping
    public void updateComment(@RequestParam String userName,@RequestBody CommentDto dto){

        commentService.updateComment(dto, userName);

    }

    @GetMapping
    public List<CommentDto> getComment(@RequestParam String userName){

        return commentService.getComment(userName);
    }

}
