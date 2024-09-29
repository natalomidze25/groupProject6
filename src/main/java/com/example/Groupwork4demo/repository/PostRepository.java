package com.example.Groupwork4demo.repository;

import com.example.Groupwork4demo.model.Post;
import com.example.Groupwork4demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long > {

    @Query("select p from Post p where p.creatorUsersName = :user")
    List<Post> getAllByUser(User user);


}
