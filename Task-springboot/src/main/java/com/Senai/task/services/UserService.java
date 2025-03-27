package com.Senai.task.services;

import com.Senai.task.dtos.ListUserDto;
import com.Senai.task.dtos.MessageDto;
import com.Senai.task.dtos.UserDto;
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
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public MessageDto insertUser(UserDto user){

        MessageDto message = new MessageDto();

        for (UserModel userModel : userRepository.findAll()){
            if (userModel.getEmail().equals(user.getEmail())){
                message.setMessage("Erro, cadastro já existente!");
                message.setSucesso(false);
                return message;
            }
        }
        UserModel userModel = new UserModel();
        userModel.setNome(user.getNome());
        userModel.setEmail(user.getEmail());
        userRepository.save(userModel);
        message.setMessage("Usuario cadastrado com sucesso.");
        message.setSucesso(true);
        return message;
    }

    public List<ListUserDto> getUsers(){

        List<ListUserDto> list = new ArrayList<>();
        List<UserModel> userModelList = userRepository.findAll();

        for (UserModel userModel : userModelList){
            ListUserDto returnUser = new ListUserDto();
            returnUser.setId(userModel.getId());
            returnUser.setNome(userModel.getNome());
            returnUser.setEmail(userModel.getEmail());
            list.add(returnUser);
        }
        return list;
    }

    public MessageDto updateUser(String email, UserDto userDto ){

        MessageDto messageDto = new MessageDto();
        Optional<UserModel> userOptinal = userRepository.findByEmail(email);
        if (!userOptinal.isPresent()){
            messageDto.setMessage("Erro ao atualizar!");
            messageDto.setSucesso(false);
            return messageDto;
        }
        UserModel userModel = userOptinal.get();
        userModel.setNome(userDto.getNome());
        userModel.setEmail(userDto.getEmail());
        userRepository.save(userModel);
        messageDto.setMessage("Usuario atualizado com sucesso!");
        messageDto.setSucesso(true);
        return messageDto;
    }

    public UserDto getUser(String email){
        UserDto userDto = new UserDto();
        String string = "";
        userDto.setEmail(string);
        userRepository.findByEmail(email);

        for (UserModel userModel : userRepository.findAll()){
            if (userModel.getEmail().equals(email)){
                userDto.setNome(userModel.getNome());
                userDto.setEmail(userModel.getEmail());
            }
        }
        return userDto;
    }

    public MessageDto deletUser(String email) {

        Optional<UserModel> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return new MessageDto(false, "usuário não encontrado");
        }

        boolean hasTasks = taskRepository.existsByUserModel_Email(email);
        if (hasTasks) {
            return new MessageDto(false, "usuário vinculado em tarefas");
        }

        userRepository.delete(userOptional.get());
        return new MessageDto(true, "usuário excluído com sucesso");
    }
}