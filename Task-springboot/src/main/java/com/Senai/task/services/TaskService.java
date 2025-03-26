package com.Senai.task.services;

import com.Senai.task.dtos.ListTaskDto;
import com.Senai.task.dtos.MessageDto;
import com.Senai.task.dtos.TaskDto;
import com.Senai.task.models.StatusEnumModel;
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
public class TaskService {

    @Autowired
    UserRepository userRepository;

    @Autowired
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
            message.setMessage("Usuario não encontrado com email.");
            message.setSucesso(false);
            return message;
        }

        Optional<TaskModel> tarefasExistentes = taskRepository.findByUsuarioEmailAndDataDeAgendamento(task.getEmailUsuario(), task.getDataDeAgendamento());
        if (tarefasExistentes.isPresent()) {
            return new MessageDto(false, "Usuário já possui tarefa agendada para esta data.");
        }

//
                TaskModel taskModel = new TaskModel();
                taskModel.setNome(task.getNome());
                taskModel.setDescricao(task.getDescricao());
                taskModel.setDataDeAgendamento(task.getDataDeAgendamento());
                taskModel.setStatus(task.getStatus());
                taskModel.setUsuario(userModel.get());
                taskRepository.save(taskModel);
                return new MessageDto(true, "Tarefa inserida com sucesso!");
//            } catch (IllegalArgumentException e) {
//                return new MessageDto(false, "Status inválido. Valores aceitos: 1-4");
//            } catch (Exception e) {
//                return new MessageDto(false, "Error ao inserir tarefa: " + e.getMessage());
//            }
        }

    public MessageDto updateTask(TaskDto task){
        Optional<UserModel> userModel = userRepository.findByEmail(task.getEmailUsuario());
        MessageDto message = new MessageDto();

        if (userModel.isEmpty()){
            message.setMessage("Erro, usuario não encontrado!");
            message.setSucesso(false);
            return message;
        }

        try {
//        StatusEnumModel status = StatusEnumModel.fromCodigo(task.getStatus());

        UserModel user = userModel.get();
        TaskModel taskModel = new TaskModel();
        taskModel.setNome(task.getNome());
        taskModel.setDescricao(task.getDescricao());
        taskModel.setDataDeAgendamento(task.getDataDeAgendamento());
        taskModel.setStatus(task.getStatus());
        taskModel.setUsuario(user);
        taskRepository.save(taskModel);
            return new MessageDto(true, "Tarefa inserida com sucesso!");
        } catch(IllegalArgumentException e){
            return new MessageDto(false, "Status inválido. Valores aceitos: 1-4");
        } catch (Exception e){
            return new MessageDto(false, "Error ao inserir tarefa: " + e.getMessage());
        }
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
