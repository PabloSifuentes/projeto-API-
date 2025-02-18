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

import javax.xml.transform.Result;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    //--Injeção de dependência
    @Autowired
    CalculadoraService service;

    @PostMapping("/somar")
    public ResponseEntity<ResultadoDto> somar(@RequestBody CalculoDto dados) {

        ResultadoDto resultado = service.somar(dados);
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/multiplicacao")
    public ResponseEntity<ResultadoDto> multiplicar(@RequestBody CalculoDto dados) {

        ResultadoDto resultado = service.multiplicar(dados);
        return ResponseEntity.ok().body(resultado);
    }

}
