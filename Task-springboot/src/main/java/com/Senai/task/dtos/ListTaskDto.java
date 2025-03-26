package com.Senai.task.dtos;

import com.Senai.task.models.StatusEnumModel;

import java.time.LocalDate;
import java.util.Date;

public class ListTaskDto {

    private Long id;

    private String nome;

    private String descricao;

    private LocalDate dataDeAgendamento;

    private StatusEnumModel status;

    private String emailUsuario;

    public ListTaskDto() {}

    public ListTaskDto(Long id, String nome, String descricao, LocalDate dataDeAgendamento, StatusEnumModel status, String emailUsuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeAgendamento = dataDeAgendamento;
        this.status = status;
        this.emailUsuario = emailUsuario;
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

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public String toString() {
        return "ListTaskDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataDeAgendamento=" + dataDeAgendamento +
                ", status='" + status + '\'' +
                ", emailUsuario='" + emailUsuario + '\'' +
                '}';
    }
}
