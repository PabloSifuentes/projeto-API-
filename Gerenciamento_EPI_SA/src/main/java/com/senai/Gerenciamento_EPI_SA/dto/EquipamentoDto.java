package com.senai.Gerenciamento_EPI_SA.dto;

import com.senai.Gerenciamento_EPI_SA.model.EquipamentoModel;
import jakarta.validation.constraints.NotBlank;

public class EquipamentoDto {

    private Long id;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotBlank(message = "Tipo é obrigatório")
    private String tipo;

    private boolean disponivel;

    public EquipamentoDto() {
    }

    public EquipamentoDto(EquipamentoModel equipamento) {
        this.id = equipamento.getId();
        this.descricao = equipamento.getDescricao();
        this.tipo = equipamento.getTipo();
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
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