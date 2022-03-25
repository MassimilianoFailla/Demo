package com.example.demo.repository;

import java.util.List;
import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer>{

    Users findById(Long id);

    @Override
    default List<Users> findAll() {

        return null;
    }

}