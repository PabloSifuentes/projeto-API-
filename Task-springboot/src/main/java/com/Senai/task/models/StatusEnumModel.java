package com.Senai.task.models;

public enum StatusEnumModel {

    EM_ABERTO(1, "Em aberto"),
    EM_ANDAMENTO(2, "Em andamento"),
    CONCLUÍDO(3, "Concluído"),
    CANCELADO(4, "Cancelado");

    private int codigo;
    private String descricao;

    StatusEnumModel(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static StatusEnumModel fromCodigo(int codigo){
          for (StatusEnumModel statusDto : StatusEnumModel.values()){
              if (statusDto.getCodigo() == codigo){
                  return statusDto;
              }
          }
          return StatusEnumModel.valueOf(("status invalido"));
    }
}
