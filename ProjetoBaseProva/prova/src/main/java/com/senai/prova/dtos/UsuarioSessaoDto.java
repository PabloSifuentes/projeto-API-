package com.senai.prova.dtos;

public class UsuarioSessaoDto {

    private String email;

    private String senha;

    public UsuarioSessaoDto() {
        this.email = "";
        this.senha = "";
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
