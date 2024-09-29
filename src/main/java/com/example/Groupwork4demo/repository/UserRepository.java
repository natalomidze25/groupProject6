package com.example.Groupwork4demo.repository;

import com.example.Groupwork4demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.username = :userName")
    User findByUserName(String userName);

    @Query("select u from User u where u.username = :userName")
    Optional<User> findOptionalByUserName(String userName);
}
