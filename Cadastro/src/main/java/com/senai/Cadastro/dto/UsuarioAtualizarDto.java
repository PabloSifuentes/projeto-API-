package com.senai.Cadastro.dto;

import com.senai.Cadastro.models.UsuarioModel;

public class UsuarioAtualizarDto {

    private Long id;

    private String nome;

    private  String login;

    private String senha;

    private String telefone;

    public UsuarioAtualizarDto() {
    }

    public UsuarioAtualizarDto(Long id){
        this.id = id;
    }

    public UsuarioAtualizarDto(UsuarioModel usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.telefone = usuario.getTelefone();
    }

    public UsuarioAtualizarDto(Long id, String nome, String login, String senha, String telefone) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
