package com.senai.prova.models;

import com.senai.prova.dtos.PacienteDto;
import jakarta.persistence.*;

@Entity
@Table(name= "PACIENTE")
public class PacienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    public PacienteModel() {
    }

    public PacienteModel(PacienteDto pacienteDto) {
        this.id = pacienteDto.getId();
        this.nome = pacienteDto.getNome();
        this.endereco = pacienteDto.getEndereco();
        this.telefone = pacienteDto.getTelefone();
        this.email = pacienteDto.getEmail();
        this.observacao = pacienteDto.getObservacao();
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
