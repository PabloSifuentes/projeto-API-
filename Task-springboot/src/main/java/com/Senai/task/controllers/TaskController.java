package com.Senai.task.controllers;

import com.Senai.task.dtos.TaskDto;
import com.Senai.task.services.TaskSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskSevice service;

    @PostMapping("/task")
    public ResponseEntity<Object> criarTask(@RequestBody @Valid TaskDto task){

        Object insert = service.insertTask(task);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/task")
    public ResponseEntity<Object> obterTask(){

        //metodo obter tarefa
        return ResponseEntity.ok().body(obterTask());
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable Long id, @RequestBody @Valid TaskDto task){

        //metodo para atualizar tarefa
        return ResponseEntity.ok().body(task);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Object> deletTask(@PathVariable Long id){

        //metodo para deletar uma task
        return ResponseEntity.ok().body(id);
    }


}
