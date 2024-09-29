package com.example.Groupwork4demo.dto;


import com.example.Groupwork4demo.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String username;
    private LocalDate dateOfBirth;

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.dateOfBirth = user.getDateOfBirth();
    }
}
