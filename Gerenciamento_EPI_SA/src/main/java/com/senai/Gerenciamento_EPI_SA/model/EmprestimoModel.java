package com.senai.Gerenciamento_EPI_SA.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "EMPRESTIMO")
public class EmprestimoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private ColaboradoresModel colaborador;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private EquipamentoModel equipamento;

    @Column(name = "data_emprestimo", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "data_devolucao", nullable = false)
    private LocalDate devolucao;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    public EmprestimoModel() {
    }

    public EmprestimoModel(Long id, ColaboradoresModel colaborador, EquipamentoModel equipamento, LocalDate dataEmprestimo, LocalDate devolucao, String observacao) {
        this.id = id;
        this.colaborador = colaborador;
        this.equipamento = equipamento;
        this.dataEmprestimo = dataEmprestimo;
        this.devolucao = devolucao;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ColaboradoresModel getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradoresModel colaborador) {
        this.colaborador = colaborador;
    }

    public EquipamentoModel getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipamentoModel equipamento) {
        this.equipamento = equipamento;
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
