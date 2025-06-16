package com.senai.Gerenciamento_EPI_SA.model;

import com.senai.Gerenciamento_EPI_SA.dto.ColaboradoresDto;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(nullable = false, name = "setor")
    private String setor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false, name = "data_nascimento")
    private LocalDate nascimento;

    public ColaboradoresModel() {
    }

    public ColaboradoresModel(ColaboradoresDto colaboradoresDto) {
        this.id = colaboradoresDto.getId();
        this.nome = colaboradoresDto.getNome();
        this.email = colaboradoresDto.getEmail();
        this.funcao = colaboradoresDto.getFuncao();
        this.setor = colaboradoresDto.getSetor();
        this.nascimento = colaboradoresDto.getNascimento();
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
