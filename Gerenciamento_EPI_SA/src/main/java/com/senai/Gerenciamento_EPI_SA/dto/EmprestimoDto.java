package com.senai.Gerenciamento_EPI_SA.dto;

import com.senai.Gerenciamento_EPI_SA.model.EmprestimoModel;

import java.time.LocalDate;

public class EmprestimoDto {

    private Long id;
    private String nomeColaborador;
    private String tipoEquipamento;
    private Long colaboradorId;  // Novo campo
    private Long equipamentoId;
    private LocalDate dataEmprestimo;
    private LocalDate devolucao;
    private String observacao;

    public EmprestimoDto() {
    }

    public EmprestimoDto(EmprestimoModel emprestimoModel) {
        this.id = emprestimoModel.getId();
        this.nomeColaborador = emprestimoModel.getColaborador().getNome();
        this.tipoEquipamento = emprestimoModel.getEquipamento().getTipo();
        this.dataEmprestimo = emprestimoModel.getDataEmprestimo();
        this.devolucao = emprestimoModel.getDevolucao();
        this.observacao = emprestimoModel.getObservacao();

        System.out.println("Convertendo - Data: " + this.dataEmprestimo);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
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
