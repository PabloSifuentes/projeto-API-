package com.senai.Cadastro.controller;

import com.senai.Cadastro.dto.LoginUsuarioDto;
import com.senai.Cadastro.dto.MensagemDto;
import com.senai.Cadastro.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticaçãoController {

    @Autowired
    UsuarioServico service;

    @PostMapping("/login")
    public ResponseEntity<MensagemDto> login(@RequestBody LoginUsuarioDto login){

        MensagemDto mensagem = service.LoginUsuario(login);
        return ResponseEntity.ok().body(mensagem);
    }
}
