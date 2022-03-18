package com.example.demo.services.impl;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDTO findUsers(Long id){

        Users user = userRepository.findById(id);
        UserDTO userDto = null;

        if(user != null){
            userDto = modelMapper.map(user, UserDTO.class);
        }
        return userDto;
    }

    @Override
    @Transactional
    public void InsUser(Users user) {

        userRepository.save(user);

    }

    @Override
    public List<UserDTO> findAll() {

        List<Users> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();

        for(int i = 0; i <userList.size(); i++){
            Users user = userList.get(i);
            userDTOList.add(modelMapper.map(user, UserDTO.class));
        }
        return userDTOList;
    }


    
}
