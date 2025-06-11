package com.senai.Gerenciamento_EPI_SA.dto;

import com.senai.Gerenciamento_EPI_SA.model.EmprestimoModel;

import java.time.LocalDate;

public class EmprestimoDto {

    private Long id;

    private Long colaboradorId;

    private Long equipamentoId;

    private LocalDate dataEmprestimo;

    private LocalDate devolucao;

    private String observacao;

    public EmprestimoDto() {
    }

    public EmprestimoDto(EmprestimoModel emprestimoModel) {
        this.id = emprestimoModel.getId();
        this.colaboradorId = emprestimoModel.getColaborador().getId();
        this.equipamentoId = emprestimoModel.getEquipamento().getId();
        this.dataEmprestimo = emprestimoModel.getDataEmprestimo();
        this.devolucao = emprestimoModel.getDevolucao();
        this.observacao = emprestimoModel.getObservacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Long colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public Long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(LocalDate devolucao) {
        this.devolucao = devolucao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
