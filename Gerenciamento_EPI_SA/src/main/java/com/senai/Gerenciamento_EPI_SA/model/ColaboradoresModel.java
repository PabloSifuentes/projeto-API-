package com.senai.Gerenciamento_EPI_SA.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "COLABORADOR")
public class ColaboradoresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, unique = true , name = "email")
    private String email;

    @Column(nullable = false, name = "funcao")
    private String funcao;

    @Column(nullable = false, name = "data_nascimento")
    private LocalDate nascimento;

    public ColaboradoresModel() {
    }

    public ColaboradoresModel(Long id, String nome, String email, String funcao, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.funcao = funcao;
        this.nascimento = nascimento;
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
