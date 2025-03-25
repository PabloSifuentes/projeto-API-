package com.Senai.task.models;
import jakarta.persistence.*;

import java.util.Date;
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
    private Date dataDeAgendamento;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserModel usuario;

    public TaskModel() {}

    public TaskModel(Long id, String nome, String descricao, Date dataDeAgendamento, String status, UserModel usuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeAgendamento = dataDeAgendamento;
        this.status = status;
        this.usuario = usuario;
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

    public Date getDataDeAgendamento() {
        return dataDeAgendamento;
    }

    public void setDataDeAgendamento(Date dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataDeAgendamento=" + dataDeAgendamento +
                ", status='" + status + '\'' +
                ", Usuario=" + usuario +
                '}';
    }
}
