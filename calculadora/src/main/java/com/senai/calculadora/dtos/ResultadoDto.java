package com.senai.calculadora.dtos;

import lombok.Data;

@Data
public class ResultadoDto {

    private int numero1;
    private String operacao;
    private int numero2;
    private int resultado;

}
