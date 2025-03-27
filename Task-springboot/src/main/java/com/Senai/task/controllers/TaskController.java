package com.Senai.task.controllers;

import com.Senai.task.dtos.ListTaskDto;
import com.Senai.task.dtos.MessageDto;
import com.Senai.task.dtos.TaskDto;
import com.Senai.task.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService service;

    @PostMapping
    public ResponseEntity<MessageDto> criarTask(@RequestBody @Valid TaskDto task) {

        MessageDto insert = service.insertTask(task);
        if (insert.isSucesso()) {
            return ResponseEntity.ok().body(insert);
        }
        if (insert.getMessage().equals("Usuario não encontrado com email.")) {
            return ResponseEntity.status(404).body(insert);
        }
        if (insert.getMessage().equals("Usuário já possui tarefa agendada para esta data.")){
        return ResponseEntity.status(409).body(insert);
        }
        return ResponseEntity.status(400).body(insert);
    }

    @GetMapping
    public ResponseEntity<Object> obterTask(){

        List<ListTaskDto> list = service.obterTarefas();
        if (list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista de tarefas vazia.");
        }
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> updateTask(@PathVariable Long id, @RequestBody @Valid TaskDto task) {

        MessageDto message = service.updateTask(id, task);
        if (message.isSucesso()) {
            return ResponseEntity.ok().body(message);
        }
        if (message.getMessage().equals("Erro: Tarefa não encontrada para atualização.")) {
            return ResponseEntity.status(404).body(new MessageDto(false, "Erro ao inserir tarefa"));
        }
        return ResponseEntity.status(500).body(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deletTask(@PathVariable Long id){

        MessageDto deletar = service.deletTask(id);
        if (deletar != null){
        return ResponseEntity.ok().body(deletar);
        }
        if (deletar == null){
            return ResponseEntity.status(404).body(deletar);
        }
        return ResponseEntity.status(500).body(deletar);
    }


}
