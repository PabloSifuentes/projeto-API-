package com.senai.calculadora.controllers;

import com.senai.calculadora.dtos.CalculoDto;
import com.senai.calculadora.dtos.ResultadoDto;
import com.senai.calculadora.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    //--Injeção de dependência
    @Autowired
    CalculadoraService service;

    @PostMapping("/realizarOperacao")
    public ResponseEntity<ResultadoDto> operacao(@RequestBody CalculoDto dados ) {

        ResultadoDto resultado = service.realizarOperacao(dados);
        return ResponseEntity.ok().body(resultado);
    }
    }

