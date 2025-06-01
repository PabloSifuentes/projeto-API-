package com.senai.prova.services;

import com.senai.prova.dtos.LoginDto;
import com.senai.prova.dtos.UsuarioSessaoDto;
import com.senai.prova.models.UsuarioModel;
import com.senai.prova.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
   
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public UsuarioSessaoDto realizarLogin(LoginDto usuarioDto){

            UsuarioSessaoDto usuarioSessao = new UsuarioSessaoDto();

            Optional<UsuarioModel> usuarioOptional = usuarioRepository.findByEmail(usuarioDto.getEmail());

            if (usuarioOptional.isPresent()){

                if (usuarioOptional.get().getSenha().equals(usuarioDto.getSenha())){

                    usuarioSessao.setId(usuarioOptional.get().getId());
                    usuarioSessao.setNome(usuarioOptional.get().getEmail());
                }
            }

        return usuarioSessao;
    }
    
}
