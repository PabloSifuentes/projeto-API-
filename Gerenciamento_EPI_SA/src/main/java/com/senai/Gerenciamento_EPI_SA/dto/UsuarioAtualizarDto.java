package com.senai.Gerenciamento_EPI_SA.dto;

import com.senai.Gerenciamento_EPI_SA.model.UsuarioModel;

public class UsuarioAtualizarDto {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    public UsuarioAtualizarDto() {
    }

    public UsuarioAtualizarDto(Long id) {
        this.id = id;
    }

    //--Construtura criado para receber um Model na hora de criação de um DTO
    public UsuarioAtualizarDto(UsuarioModel usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
