package com.senai.crud.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Size(max = 300)
    @Column(name = "descricao", nullable = false, length = 300)
    private String descricao;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "quantidadeEmEstoque", nullable = false)
    private Long quantidadeEmEstoque;

    public ProdutoModel() {
    }

    public ProdutoModel(Long id, String nome, String descricao, Double preco, Long quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
       if (preco < 0){
           throw new IllegalArgumentException("Erro, valor deve ser positivo");
       }
        this.preco = preco;
    }

    public Long getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Long quantidadeEmEstoque) {
        if(quantidadeEmEstoque < 0){
            throw new IllegalArgumentException("Erro, valor não pode ser negativo");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
