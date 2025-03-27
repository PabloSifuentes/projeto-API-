
package com.Senai.task.dtos;

import com.Senai.task.models.StatusEnumModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Date;

public class TaskDto {

    private Long id;

    @NotNull(message = "O nome não pode estar em branco!")
    private String nome;
    @NotNull(message = "A descrição não pode estar branco!")
    private String descricao;
    @NotNull(message = "A data do agendamento não pode estar em branco")
    private LocalDate dataDeAgendamento;

    private StatusEnumModel status;

    @NotNull(message = "O email não pode estar em branco!")
    private String emailUsuario;

    public TaskDto() {}

    public TaskDto(Long id, String nome, String descricao, LocalDate dataDeAgendamento, StatusEnumModel status, String emailUsuario) {
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

    public @NotNull(message = "O nome não pode estar em branco!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O nome não pode estar em branco!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "A descrição não pode estar branco!") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "A descrição não pode estar branco!") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "A data do agendamento não pode estar em branco") LocalDate getDataDeAgendamento() {
        return dataDeAgendamento;
    }

    public void setDataDeAgendamento(@NotNull(message = "A data do agendamento não pode estar em branco") LocalDate dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

    public StatusEnumModel getStatus() {
        return status;
    }

    public void setStatus(StatusEnumModel status) {
        this.status = status;
    }

    public @NotNull(message = "O email não pode estar em branco!") String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(@NotNull(message = "O email não pode estar em branco!") String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataDeAgendamento=" + dataDeAgendamento +
                ", status='" + status + '\'' +
                ", emailUsuario='" + emailUsuario + '\'' +
                '}';
    }
}
