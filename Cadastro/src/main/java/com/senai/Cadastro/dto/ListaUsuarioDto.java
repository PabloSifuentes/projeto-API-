package com.senai.Cadastro.dto;

import com.senai.Cadastro.models.UsuarioModel;

public class ListaUsuarioDto {

    private Long id;
    private String nome;
    private String login;
    private String telefone;

    public ListaUsuarioDto(){
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
}
