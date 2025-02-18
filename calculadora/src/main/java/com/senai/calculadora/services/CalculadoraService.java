package com.senai.calculadora.services;

import com.senai.calculadora.dtos.CalculoDto;
import com.senai.calculadora.dtos.ResultadoDto;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public ResultadoDto somar(CalculoDto dados) {

    ResultadoDto resultado = new ResultadoDto();
    resultado.setResultado(dados.getValor1() + dados.getValor2());

    return resultado;
    }

    public ResultadoDto multiplicar(CalculoDto dados) {

        ResultadoDto resultado = new ResultadoDto();
        resultado.setResultado(dados.getValor1() * dados.getValor2());

        return resultado;
    }
}






