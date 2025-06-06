package com.senai.prova.dtos;

import com.senai.prova.models.PacienteModel;

public class PacienteDto {

    private Long id;

    private String nome;

    private String endereco;

    private String telefone;

    private String email;

    private String observacao;

    public PacienteDto() {
    }

    public PacienteDto(PacienteModel pacienteModel) {
        this.id = pacienteModel.getId();
        this.nome = pacienteModel.getNome();
        this.endereco = pacienteModel.getEndereco();
        this.telefone = pacienteModel.getTelefone();
        this.email = pacienteModel.getEmail();
        this.observacao = pacienteModel.getObservacao();
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
