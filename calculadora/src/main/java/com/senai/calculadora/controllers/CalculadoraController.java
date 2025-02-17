package com.senai.calculadora.controllers;

import com.senai.calculadora.dtos.CalculoDto;
import com.senai.calculadora.dtos.ResultadoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    @PostMapping
    public ResponseEntity<ResultadoDto> somar(@RequestBody CalculoDto dados) {

        ResultadoDto resultado = new ResultadoDto();
        resultado.setResultado(dados.getValor1() + dados.getValor2());

        return ResponseEntity.ok().body(resultado);
    }

}
