package com.senai.Gerenciamento_EPI_SA.dto;

import java.util.List;

public class PerfilRiscoDto {
    private Long id;
    private String funcao;  // Mantido como funcao
    private String setor;
    private List<String> riscosSelecionados;
    private List<Long> episIds;

    // Construtores
    public PerfilRiscoDto() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
    public List<String> getRiscosSelecionados() { return riscosSelecionados; }
    public void setRiscosSelecionados(List<String> riscosSelecionados) {
        this.riscosSelecionados = riscosSelecionados;
    }
    public List<Long> getEpisIds() { return episIds; }
    public void setEpisIds(List<Long> episIds) { this.episIds = episIds; }
}