package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role,Integer> {

    @Query("select distinct c.role_type from Role c  where c.role_id = :role_id ")
    String findType(@Param("role_id") int role_id);
}
