package com.Senai.task.controllers;

import com.Senai.task.dtos.ListTaskDto;
import com.Senai.task.dtos.MessageDto;
import com.Senai.task.dtos.TaskDto;
import com.Senai.task.services.TaskSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskSevice service;

    @PostMapping("/task")
    public ResponseEntity<MessageDto> criarTask(@RequestBody @Valid TaskDto task) {

        MessageDto insert = service.insertTask(task);
        if (insert.isSucesso()) {
            return ResponseEntity.ok(new MessageDto(true, "Tarefa inserida com sucesso"));
        }

        String errorMessage = insert.getMessage();

        if (errorMessage.equals("Usuario da tarefa não enocntrado")) {
            return ResponseEntity.status(404).body(insert);
        }
        if (errorMessage.equals("Usuario ja possui agenda para a data insformada.")){
        return ResponseEntity.status(409).body(insert);
        }
        return ResponseEntity.status(400).body(insert);
    }

    @GetMapping("/task")
    public ResponseEntity<List<ListTaskDto>> obterTask(){

        List<ListTaskDto> list = service.obterTarefas();
        if (list.isEmpty()){
            return ResponseEntity.status(404).body(list);
        }
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<MessageDto> updateTask(@PathVariable Long id, @RequestBody @Valid TaskDto task) {

        MessageDto message = service.updateTask(task);
        if (message.isSucesso()) {
            return ResponseEntity.ok().body(message);
        }
        if (message.getMessage().equals("Erro: Tarefa não encontrada para atualização.")) {
            return ResponseEntity.status(404).body(new MessageDto(false, "tarefa não enocntrada"));
        }
        return ResponseEntity.status(500).body(message);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Object> deletTask(@PathVariable Long id){

        Object deletar = service.deletTask(id);
        if (deletar != null){
        return ResponseEntity.ok().body(id);
        }
        if (deletar == null){
            return ResponseEntity.status(404).body(deletar);
        }
        return ResponseEntity.status(500).body(deletar);
    }


}
