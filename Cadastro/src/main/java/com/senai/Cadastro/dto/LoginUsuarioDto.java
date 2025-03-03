package com.senai.Cadastro.dto;

public class LoginUsuarioDto {

    private String login;
    private String senha;

    public LoginUsuarioDto(){
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
