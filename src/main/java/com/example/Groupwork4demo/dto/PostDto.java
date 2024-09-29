package com.example.Groupwork4demo.dto;

import com.example.Groupwork4demo.model.Post;
import com.example.Groupwork4demo.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
public class PostDto {
    private Long id;

    @NotNull
    private String text;

    private String userName;

    public PostDto(Post post) {
        this.id = post.getId();
        this.text = post.getText();
        this.userName = post.getCreatorUsersName().getUsername();
    }
}
