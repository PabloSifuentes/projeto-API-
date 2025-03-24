package com.Senai.task.controllers;


import com.Senai.task.dtos.ListUserDto;
import com.Senai.task.dtos.MessageDto;
import com.Senai.task.dtos.UserDto;
import com.Senai.task.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/user")
    public ResponseEntity<MessageDto> register(@RequestBody @Valid UserDto usuario){

        MessageDto message = service.insertUser(usuario);
        if (message.isSucesso()){
        return ResponseEntity.ok().body(message);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @PutMapping("/user/{email}")
    public ResponseEntity<MessageDto> updateUser(@PathVariable java.lang.String email, @RequestBody UserDto usuario){

        MessageDto message = service.updateUser(email, usuario);
        if (message.isSucesso()){
        return ResponseEntity.ok().body(message);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ListUserDto>> listUser(){

        List<ListUserDto> list = service.getUsers();
        if (list == null || list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<MessageDto> deletUser(@PathVariable java.lang.String email){

        MessageDto userDelet = service.deletUser(email);
        if (userDelet.isSucesso()){
        return ResponseEntity.ok().body(userDelet);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userDelet);
    }
}
