package com.senai.Gerenciamento_EPI_SA.repository;

import com.senai.Gerenciamento_EPI_SA.model.PerfilRiscoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PerfilRiscoRepository extends JpaRepository<PerfilRiscoModel, Long> {
    List<PerfilRiscoModel> findByFuncaoAndSetor(String funcao, String setor);

    @Query("SELECT DISTINCT p FROM PerfilRiscoModel p LEFT JOIN FETCH p.episRecomendados")
    List<PerfilRiscoModel> findAllWithEpis();
}