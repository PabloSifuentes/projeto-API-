package com.senai.crud.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categorias")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 300)
    @Column(name = "descricao", nullable = false, length = 300)
    private String descricao;

    public CategoriaModel() {
    }

    public CategoriaModel(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(max = 300) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Size(max = 300) String descricao) {
        this.descricao = descricao;
    }
}
