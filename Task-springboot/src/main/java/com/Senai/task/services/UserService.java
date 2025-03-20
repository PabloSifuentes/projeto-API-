package com.Senai.task.services;

import com.Senai.task.dtos.ListUserDto;
import com.Senai.task.dtos.MessageDto;
import com.Senai.task.dtos.UserDto;
import com.Senai.task.models.UserModel;
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
            UserModel userModel = new UserModel();
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

    public MessageDto deletUser(String email){

        MessageDto messageDto = new MessageDto();
        messageDto.setMessage("Erro ao excluir!");
        messageDto.setSucesso(false);

        UserModel delet = new UserModel();
        String string = "";
        delet.setEmail(string);
        for (UserModel user : userRepository.findAll()){
            if (delet.getEmail().equals(email)){
                delet = user;
            }
            if (!delet.getEmail().isEmpty()){
                userRepository.delete(delet);
                messageDto.setMessage("Usuario excluido com sucesso!");
                messageDto.setSucesso(true);
                userRepository.delete(user);
            }
        }
        return messageDto;
    }

}
