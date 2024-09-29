package com.example.Groupwork4demo.dto;

import com.example.Groupwork4demo.model.Comment;
import com.example.Groupwork4demo.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class CommentDto {
    private Long id;


    @NotNull
    private String text;

    private Long postId;

    private User author;

    public CommentDto() {
    }

    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.text = comment.getText();
        this.postId = comment.getId();
        this.author = comment.getAuthor();
    }
}
