package com.senai.Cadastro.controller;

import com.senai.Cadastro.dto.RequisicaoDto;

import com.senai.Cadastro.dto.MenssagemDto;
import com.senai.Cadastro.service.CadastroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
public class cadastroController {

    @Autowired
    CadastroServico service;

    @PostMapping("/usuario")
    public ResponseEntity<MenssagemDto> cadastrar(@RequestBody RequisicaoDto usuario){
        MenssagemDto menssagem = new MenssagemDto();

        return ResponseEntity.ok().body(menssagem);
    }
    @PostMapping("/")

}
