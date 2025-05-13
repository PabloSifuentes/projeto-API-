package com.senai.crud.dtos;

public class ListaCategoriasDto {

    private Long id;

    private String descricao;

    public ListaCategoriasDto() {
    }

    public ListaCategoriasDto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
