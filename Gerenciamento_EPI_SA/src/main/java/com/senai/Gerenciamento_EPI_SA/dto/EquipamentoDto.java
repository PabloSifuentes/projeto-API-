package com.senai.Gerenciamento_EPI_SA.dto;

import com.senai.Gerenciamento_EPI_SA.model.EquipamentoModel;

public class EquipamentoDto {

    private Long id;

    private String descricao;

    private String tipo;

    public EquipamentoDto() {
    }

    public EquipamentoDto(EquipamentoModel equipamento) {
        this.id = equipamento.getId();
        this.descricao = equipamento.getDescricao();
        this.tipo = equipamento.getTipo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
