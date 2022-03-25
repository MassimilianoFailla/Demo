package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
    
    UserDTO findUsers(Long id);

    public void InsUser(Users user);

    Iterable<UserDTO> findAll();

}