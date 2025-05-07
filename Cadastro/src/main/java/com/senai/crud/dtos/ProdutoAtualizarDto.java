package com.senai.crud.dtos;

import com.senai.crud.models.ProdutoModel;

public class ProdutoAtualizarDto {

    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    private Long quantidadeEmEstoque;

    public ProdutoAtualizarDto() {
    }

    public ProdutoAtualizarDto(String nome, String descricao, Double preco, Long quantidadeEmEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public ProdutoAtualizarDto(long l) {
        this.id = id;
    }

    public ProdutoAtualizarDto(ProdutoModel produtoModel) {
        this.id = produtoModel.getId();
        this.nome = produtoModel.getNome();
        this.descricao = produtoModel.getDescricao();
        this.preco = produtoModel.getPreco();
        this.quantidadeEmEstoque = produtoModel.getQuantidadeEmEstoque();
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
        this.preco = preco;
    }

    public Long getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Long quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}

