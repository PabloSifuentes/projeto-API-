package com.senai.Gerenciamento_EPI_SA.dto;

import com.senai.Gerenciamento_EPI_SA.model.ColaboradoresModel;
import jakarta.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ColaboradoresDto {

    private Long id;

    private String nome;

    private String email;

    private String funcao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate nascimento;

    public ColaboradoresDto() {
    }

    public ColaboradoresDto(ColaboradoresModel colaboradoresModel) {
        this.id = colaboradoresModel.getId();
        this.nome = colaboradoresModel.getNome();
        this.email = colaboradoresModel.getEmail();
        this.funcao = colaboradoresModel.getFuncao();
        this.nascimento = colaboradoresModel.getNascimento();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
