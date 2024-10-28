package com.example.Groupwork4demo.controller;

import com.example.Groupwork4demo.dto.CommentDto;
import com.example.Groupwork4demo.security.JwtUtils;
import com.example.Groupwork4demo.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("comment")
@RestController
public class CommentController {
    @Autowired
     private CommentService commentService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping
    public void createComment(@RequestBody CommentDto dto, HttpServletRequest request){
        commentService.createComment(dto,jwtUtils.getUserNameFromRequest(request));

    }

    @DeleteMapping
    public void deleteComment(@RequestParam Long id, HttpServletRequest request){

        commentService.deleteComment(id, jwtUtils.getUserNameFromRequest(request));
    }


    @PutMapping
    public void updateComment(@RequestBody CommentDto dto, HttpServletRequest request){

        commentService.updateComment(dto, jwtUtils.getUserNameFromRequest(request));

    }

    @GetMapping
    public List<CommentDto> getComment( HttpServletRequest request){

        return commentService.getComment(jwtUtils.getUserNameFromRequest(request));
    }

}
