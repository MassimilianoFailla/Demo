package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServices userService;

    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        try {
            List<Users> items = new ArrayList<Users>();

            userRepository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Long id) {

        logger.info("Visualizzazione utente con id -> %d", + id);

        UserDTO userDTO = userService.findUsers(id);

        return new ResponseEntity<UserDTO>(userDTO, new HttpHeaders(), HttpStatus.OK);

    }

    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody Users user) {

        logger.info("Salvo l'utente con id " + user.getId());

        UserDTO userDTO = userService.findUsers(user.getId());
        logger.info("USER DTO: ", userDTO);
        if (userDTO != null) {
            String MsgErr = String.format("Utente con id -> " + userDTO.getId() + " presente! - Impossibile inserire!",
                    userDTO.getId());
            logger.warn(MsgErr);
        }

        logger.info("hai salvato l'utente\n\n\n" + "-> " +user);

        userService.InsUser(user);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode responseNode = mapper.createObjectNode();
        responseNode.put("code", HttpStatus.OK.toString());
        responseNode.put("message", String.format("Inserimento nuovo utente con id -> " + user.getId() + "eseguito con successo"));
        return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.CREATED);

    }

    // @PutMapping("{id}")
    // public ResponseEntity<entityClassName> update(@PathVariable("id") entityIdType id, @RequestBody entityClassName item) {
    //     Optional<entityClassName> existingItemOptional = repository.findById(id);
    //     if (existingItemOptional.isPresent()) {
    //         entityClassName existingItem = existingItemOptional.get();
    //         //existingItem.setSomeField(item.getSomeField());
    //         return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // @DeleteMapping("{id}")
    // public ResponseEntity<HttpStatus> delete(@PathVariable("id") entityIdType id) {
    //     try {
    //         repository.deleteById(id);
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    //     }
    // }
}