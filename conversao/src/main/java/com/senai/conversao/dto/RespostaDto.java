package com.senai.conversao.dto;

import lombok.Data;

@Data
public class RespostaDto {

    private Double valorOriginal;
    private String tipoConversao;
    private Double valorConvertido;
}
