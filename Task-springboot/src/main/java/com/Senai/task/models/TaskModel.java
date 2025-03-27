package com.Senai.task.models;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "tarefas")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    private LocalDate dataDeAgendamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusEnumModel status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserModel userModel;

    public TaskModel() {}

    public TaskModel(Long id, String nome, String descricao, LocalDate dataDeAgendamento, StatusEnumModel status, UserModel userModel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeAgendamento = dataDeAgendamento;
        this.status = status;
        this.userModel = userModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDeAgendamento() {
        return dataDeAgendamento;
    }

    public void setDataDeAgendamento(LocalDate dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

    public StatusEnumModel getStatus() {
        return status;
    }

    public void setStatus(StatusEnumModel status) {
        this.status = status;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataDeAgendamento=" + dataDeAgendamento +
                ", status='" + status + '\'' +
                ", Usuario=" + userModel +
                '}';
    }
}
