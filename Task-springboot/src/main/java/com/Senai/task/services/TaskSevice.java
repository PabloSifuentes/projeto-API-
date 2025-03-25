package com.Senai.task.services;

import com.Senai.task.dtos.ListTaskDto;
import com.Senai.task.dtos.MessageDto;
import com.Senai.task.dtos.TaskDto;
import com.Senai.task.models.TaskModel;
import com.Senai.task.models.UserModel;
import com.Senai.task.repositories.TaskRepository;
import com.Senai.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskSevice {

    @Autowired
    UserRepository userRepository;
    TaskRepository taskRepository;

    public List<ListTaskDto> obterTarefas() {

        List<TaskModel> taskModelList = taskRepository.findAll();
        List<ListTaskDto> list = new ArrayList<>();

        for (TaskModel taskModel : taskModelList) {
            ListTaskDto returnTask = new ListTaskDto();
            returnTask.setId(taskModel.getId());
            returnTask.setNome(taskModel.getNome());
            returnTask.setDescricao(taskModel.getDescricao());
            returnTask.setDataDeAgendamento(taskModel.getDataDeAgendamento());
            returnTask.setStatus(taskModel.getStatus());
            list.add(returnTask);
        }
        return list;
    }

    public MessageDto insertTask(TaskDto task) {

        MessageDto message = new MessageDto();

        Optional<UserModel> userModel = userRepository.findByEmail(task.getEmailUsuario());
        if (userModel.isEmpty()) {
            message.setMessage("Usuario não encontrado com email: " + task.getEmailUsuario());
            message.setSucesso(false);
            return message;
        }
        TaskModel taskModel = new TaskModel();
        taskModel.setNome(task.getNome());
        taskModel.setDescricao(task.getDescricao());
        taskModel.setDataDeAgendamento(task.getDataDeAgendamento());
        taskModel.setStatus(task.getStatus());
        taskModel.setUsuario(userModel.get());
        taskRepository.save(taskModel);
        message.setMessage("Tarefa inserido com sucesso!");
        message.setSucesso(true);
        return message;
    }

    public MessageDto updateTask(TaskDto task){
        Optional<UserModel> userModel = userRepository.findByEmail(task.getEmailUsuario());
        MessageDto message = new MessageDto();

        if (userModel.isEmpty()){
            message.setMessage("Erro, usuario não encontrado!");
            message.setSucesso(false);
            return message;
        }
        UserModel user = userModel.get();
        TaskModel taskModel = new TaskModel();
        taskModel.setNome(task.getNome());
        taskModel.setDescricao(task.getDescricao());
        taskModel.setDataDeAgendamento(task.getDataDeAgendamento());
        taskModel.setStatus(task.getStatus());
        taskModel.setUsuario(user);
        taskRepository.save(taskModel);
        message.setMessage("Tarefa atualizada com sucesso.");
        message.setSucesso(true);
        return message;
    }
    public boolean deletTask(Long taskId){
        Optional<TaskModel> taskModel = taskRepository.findById(taskId);
        if (taskModel.isEmpty()){
            System.out.println("Erro, não há tarefa");
            return false;
        }
        TaskModel delet = taskRepository.getReferenceById(taskId);
        taskRepository.delete(delet);
        return true;
    }
}
