package com.senai.crud.dtos;

import com.senai.crud.models.CategoriaModel;

public class CategoriaDto {

    private Long id;

    private String descricao;

    public CategoriaDto() {
    }

    public static CategoriaDto of(CategoriaModel model) {
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setId(model.getId());
        categoriaDto.setDescricao(model.getDescricao());
        return categoriaDto;
    }

    public CategoriaDto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public CategoriaDto (Long id){
        this.id = id;
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
