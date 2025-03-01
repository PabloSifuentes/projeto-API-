package com.senai.Cadastro.dto;

import com.senai.Cadastro.models.UsuarioModel;

public class ListaUsuarioDto {

    private Integer id;
    private String nome;
    private String login;

    public ListaUsuarioDto(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
