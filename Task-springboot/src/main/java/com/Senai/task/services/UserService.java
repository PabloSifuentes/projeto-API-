package com.Senai.task.services;

import com.Senai.task.dtos.ListUserDto;
import com.Senai.task.dtos.MessageDto;
import com.Senai.task.dtos.UserDto;
import com.Senai.task.models.UserModel;
import com.Senai.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public MessageDto insertUser(UserDto user){

        MessageDto message = new MessageDto();

       for (UserModel userModel : userRepository.findAll()){
           if (userModel.getEmail().equals(user.getEmail())){
               message.setMessage("Erro, email já existente!");
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

    public List<UserDto> getUser(){

        List<UserDto> list = new ArrayList<>();

        List<UserModel> userModelList = userRepository.findAll();

//        for ()
    }

}
