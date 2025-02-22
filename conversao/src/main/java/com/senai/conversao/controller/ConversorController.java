package com.senai.conversao.controller;

import com.senai.conversao.dto.RequisicaoDto;
import com.senai.conversao.dto.RespostaDto;
import com.senai.conversao.service.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/converter")
public class ConversorController {

    //==Injeção de dependência
    @Autowired
    ConversorService service;

    @PostMapping("/realizarConversao")
    public ResponseEntity<RespostaDto> conversao(@RequestBody RequisicaoDto dados){
        RespostaDto resposta = service.realizarConversao(dados);
        return ResponseEntity.ok().body(resposta);
    }

}
