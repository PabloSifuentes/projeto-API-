package com.senai.calculadora.services;

import com.senai.calculadora.dtos.CalculoDto;
import com.senai.calculadora.dtos.ResultadoDto;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public ResultadoDto realizarOperacao(CalculoDto dados) {

        ResultadoDto resultado = new ResultadoDto();
        switch (dados.getOperacao()) {

            case "+":
                resultado.setResultado(dados.getValor1() + dados.getValor2());
                resultado.setNumero1(dados.getValor1());
                resultado.setNumero2(dados.getValor2());
                resultado.setOperacao(dados.getOperacao());
                return resultado;
            case "*":
                resultado.setResultado(dados.getValor1() * dados.getValor2());
                resultado.setNumero1(dados.getValor1());
                resultado.setNumero2(dados.getValor2());
                return resultado;
            case "-":
                resultado.setResultado(dados.getValor1() - dados.getValor2());
                resultado.setNumero1(dados.getValor1());
                resultado.setNumero2(dados.getValor2());
                return resultado;
            case "/":
                if (dados.getValor2() == 0 || dados.getValor1() == 0) {
                    resultado.setResultado((int) Double.NaN);
                } else {
                    resultado.setResultado(dados.getValor1() / dados.getValor2());
                    resultado.setNumero1(dados.getValor1());
                    resultado.setNumero2(dados.getValor2());
                }
                return resultado;
            case "^":
                resultado.setResultado((int) Math.pow(dados.getValor1(), dados.getValor2()));
                resultado.setNumero1(dados.getValor1());
                resultado.setNumero2(dados.getValor2());
                resultado.setOperacao(dados.getOperacao());
                return resultado;
            case "%":
                resultado.setNumero1(dados.getValor1());
                resultado.setNumero2(dados.getValor2());
                resultado.setOperacao(dados.getOperacao());
                resultado.setResultado(dados.getValor1() % dados.getValor2());
                return resultado;
        }
        return resultado;
    }
}






