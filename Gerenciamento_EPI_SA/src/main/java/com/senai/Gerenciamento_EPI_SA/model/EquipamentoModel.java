package com.senai.Gerenciamento_EPI_SA.model;

import com.senai.Gerenciamento_EPI_SA.dto.EquipamentoDto;
import jakarta.persistence.*;

@Entity
@Table(name = "EQUIPAMENTO")
public class EquipamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "descricao")
    private String descricao;

    @Column(nullable = false, name = "tipo")
    private String tipo;

    @Column(nullable = false, name = "disponivel")
    private boolean disponivel = true;

    public EquipamentoModel() {
    }

    public EquipamentoModel(EquipamentoDto equipamento) {
        this.id = equipamento.getId();
        this.descricao = equipamento.getDescricao();
        this.tipo = equipamento.getTipo();
        this.disponivel = true;
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
