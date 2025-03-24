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

    public List<ListTaskDto> getTask() {

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
            if (taskModel.getUsuario() != null) {
                returnTask.setEmailUsuario(taskModel.getUsuario().getEmail());
            } else {
                returnTask.setEmailUsuario("Lista de tarefas encontrado!");
            }
        }
        return list;
    }

    public boolean insertTask(TaskDto task) {

        Optional<UserModel> userModel = userRepository.findByEmail(task.getEmailUsuario());
        if (userModel.isEmpty()) {
            System.out.println("Usuario não encontrado com email: " + task.getEmailUsuario());
            return false;
        }

        TaskModel taskModel = new TaskModel();
        taskModel.setNome(task.getNome());
        taskModel.setDescricao(task.getDescricao());
        taskModel.setDataDeAgendamento(task.getDataDeAgendamento());
        taskModel.setStatus(task.getStatus());
        taskModel.setUsuario(userModel.get());
        try {
            taskRepository.save(taskModel);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir tarefa" + e);
            return false;
        }
    }

    public boolean updateTask(TaskDto task){
        Optional<UserModel> userModel = userRepository.findByEmail(task.getEmailUsuario());
        if (userModel.isEmpty()){
            System.out.println("Erro, usuario não encontrado!");
            return false;
        }
        TaskModel taskModel = new TaskModel();
        taskModel.setNome(task.getNome());
        taskModel.setDescricao(task.getDescricao());
        taskModel.setDataDeAgendamento(task.getDataDeAgendamento());
        taskModel.setStatus(task.getStatus());
        taskRepository.save(taskModel);
        return true;
    }

    public boolean deletTask(Long taskId){
        Optional<TaskModel> taskModel = taskRepository.findById(taskId);
        if (taskModel.isEmpty()){
            System.out.println("Erro tarefa não encontrado");
            return false;
        }
        TaskModel delet = taskRepository.getReferenceById(taskId);
        taskRepository.delete(delet);
        return true;
    }
}
