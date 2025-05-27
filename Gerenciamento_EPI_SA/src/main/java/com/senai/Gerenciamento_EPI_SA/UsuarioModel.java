package com.senai.Gerenciamento_EPI_SA;

import jakarta.persistence.*;

import java.util.regex.Pattern;

@Entity
@Table(name = "USUARIO")
public class UsuarioModel {

    private static final int TAMANHO_MINIMO_SENHA = 5;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    public UsuarioModel() {
    }

    public UsuarioModel(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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
        if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Campo não pode ser em branco");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Campo não pode ser em branco");
        }
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (!senhaValida(senha)) {
            throw new IllegalArgumentException(
                    "Senha deve ter no mínimo " + TAMANHO_MINIMO_SENHA + " caracteres e não pode ser em branco");
        }
        this.senha = senha;
    }

    public static boolean senhaValida(String senha){
        return senha != null &&
                !senha.trim().isEmpty() &&
                senha.length() >= TAMANHO_MINIMO_SENHA;
    }

    public static boolean EmailValido(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}
