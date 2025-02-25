package com.senai.Cadastro.controller;

import com.senai.Cadastro.dto.CadastroDto;

import com.senai.Cadastro.dto.RespostaDto;
import com.senai.Cadastro.service.CadastroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cadastro")
public class cadastroController {

    @Autowired
    CadastroServico service;
    
    @PostMapping("/realizarCadastro")
    public ResponseEntity<Boolean> cadastro(@RequestBody CadastroDto dados){
         boolean resposta = service.realizarCadastro(dados);
        return ResponseEntity.ok().body(resposta);
    }
}
