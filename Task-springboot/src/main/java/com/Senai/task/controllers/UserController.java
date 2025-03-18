package com.Senai.task.controllers;


import com.Senai.task.dtos.UserDto;
import com.Senai.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/user")
    public ResponseEntity<Object> register(@RequestBody UserDto usuario){

        //logica para cadastrar usuario
        return ResponseEntity.ok().body(usuario);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDto usuario){

        //logica para atualizar usuario
        return ResponseEntity.ok().body("alguma coisa");
    }

    @GetMapping("/users")
    public ResponseEntity<String> listUser(){

        //logica para listar usuarios
        return ResponseEntity.ok().body("alguma coisa");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> searchUser(@PathVariable Long id,@RequestBody UserDto usuario){

        //logica para buscar usuario por ID
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deletUser(@PathVariable Long id){

        //Logica para excluir
        return ResponseEntity.ok().body("alguma coisa");
    }
}
