package com.senai.Gerenciamento_EPI_SA.model;

import com.senai.Gerenciamento_EPI_SA.dto.EmprestimoDto;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "EMPRESTIMO")
public class EmprestimoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colaborador_id", nullable = false)
    private ColaboradoresModel colaborador;

    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = false)
    private EquipamentoModel equipamento;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_emprestimo", nullable = false)
    private LocalDate dataEmprestimo = LocalDate.now();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_devolucao", nullable = true)
    private LocalDate devolucao;

    @Column(name = "observacao", nullable = true)
    private String observacao;

    @Column(name = "disponivel", nullable = false, columnDefinition = "boolean default true")
    private Boolean disponivel = true;

    public EmprestimoModel() {
        this.devolucao = null;
    }

    public EmprestimoModel(EmprestimoDto emprestimoDto, EquipamentoModel equipamento, ColaboradoresModel colaborador) {
        this();
        this.colaborador = colaborador;
        this.equipamento = equipamento;
        this.observacao = emprestimoDto.getObservacao();
    }

    // Método para registrar devolução
    public void registrarDevolucao(String observacao) {
        this.devolucao = LocalDate.now();
        this.observacao = observacao;
        // Adicione esta verificação de segurança
        if (this.equipamento != null) {
            this.equipamento.setDisponivel(true);
        } else {
            throw new IllegalStateException("Empréstimo não possui equipamento associado");
        }
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
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

    // Removemos o setter para dataEmprestimo para evitar modificações indevidas
    // A data só pode ser definida automaticamente no construtor

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

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
