package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,User> {
    @Query("select u.age from User u")
    List<String> getAllEmail();

    @Query("select distinct c.role_id from User c  where c.userName = :categoryName and c.password= :password")
    String findUser(@Param("categoryName") String categoryName, @Param("password") String password);
}
