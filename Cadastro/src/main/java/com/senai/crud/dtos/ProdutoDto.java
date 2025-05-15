package com.senai.crud.dtos;

public class ProdutoDto {

    private String nome;

    private String descricao;

    private Double preco;

    private Long quantidadeEmEstoque;

    private Long categoriaid;

    public ProdutoDto() {
    }

    public ProdutoDto(String nome, String descricao, Double preco, Long quantidadeEmEstoque, Long categoriaid) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoriaid = categoriaid;
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

    public Long getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Long categoriaid) {
        this.categoriaid = categoriaid;
    }
}
