
package com.Senai.task.dtos;

import com.Senai.task.models.StatusEnumModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Date;

public class TaskDto {

    private Long id;

    @NotBlank(message = "O nome não pode estar em branco!")
    private String nome;
    @NotBlank(message = "A descrição não pode estar branco!")
    private String descricao;
    @NotBlank(message = "A data do agendamento não pode estar em branco")
    private LocalDate dataDeAgendamento;

//    @Pattern(regexp = "^[1-4]$", message = "status deve ser entre 1 a 4")
    private StatusEnumModel status;

    @NotBlank(message = "O email não pode estar em branco!")
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

    public @NotBlank(message = "O nome não pode estar em branco!") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome não pode estar em branco!") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "A descrição não pode estar branco!") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "A descrição não pode estar branco!") String descricao) {
        this.descricao = descricao;
    }

    public @NotBlank(message = "A data do agendamento não pode estar em branco") LocalDate getDataDeAgendamento() {
        return dataDeAgendamento;
    }

    public void setDataDeAgendamento(@NotBlank(message = "A data do agendamento não pode estar em branco") LocalDate dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

    public StatusEnumModel getStatus() {
        return status;
    }

    public void setStatus(StatusEnumModel status) {
        this.status = status;
    }

    public @NotBlank(message = "O email não pode estar em branco!") String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(@NotBlank(message = "O email não pode estar em branco!") String emailUsuario) {
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
