package com.senai.Gerenciamento_EPI_SA.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "PERFILRISCO")
public class PerfilRiscoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "funcao", nullable = false) // Alterado para funcao
    private String funcao;

    @Column(name = "setor", nullable = false)
    private String setor;

    @ElementCollection
    private List<String> riscos;

    @ManyToMany
    private List<EquipamentoModel> episRecomendados;

    // Construtores
    public PerfilRiscoModel() {}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
    public List<String> getRiscos() { return riscos; }
    public void setRiscos(List<String> riscos) { this.riscos = riscos; }
    public List<EquipamentoModel> getEpisRecomendados() { return episRecomendados; }
    public void setEpisRecomendados(List<EquipamentoModel> episRecomendados) {
        this.episRecomendados = episRecomendados;
    }
}