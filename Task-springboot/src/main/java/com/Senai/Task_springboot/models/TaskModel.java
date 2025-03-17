package com.Senai.Task_springboot.models;
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
    @Column(name = "descrição", nullable = false)
    private String descricao;
    @Temporal(TemporalType.DATE)
    private Date dataDeAgendamento;
    @Enumerated(EnumType.STRING)
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserModel Usuario;

    public TaskModel() {}

    public TaskModel(Long id, String nome, String descrição, Date dataDeAgendamento, String status, UserModel usuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descrição;
        this.dataDeAgendamento = dataDeAgendamento;
        this.status = status;
        Usuario = usuario;
    }

    public UserModel getUsuario() {
        return Usuario;
    }

    public void setUsuario(UserModel usuario) {
        Usuario = usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataDeAgendamento() {
        return dataDeAgendamento;
    }

    public void setDataDeAgendamento(Date dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrição='" + descricao + '\'' +
                ", dataDeAgendamento=" + dataDeAgendamento +
                ", status='" + status + '\'' +
                ", Usuario=" + Usuario +
                '}';
    }
}
