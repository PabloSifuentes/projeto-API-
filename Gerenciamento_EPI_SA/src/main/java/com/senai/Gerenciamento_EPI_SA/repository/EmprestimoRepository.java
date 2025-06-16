package com.senai.Gerenciamento_EPI_SA.repository;

import com.senai.Gerenciamento_EPI_SA.model.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, Long> {

    @Query("SELECT e FROM EmprestimoModel e WHERE e.equipamento.id = :equipamentoId AND e.devolucao IS NULL")
    List<EmprestimoModel> findEmprestimosAtivosPorEquipamento(@Param("equipamentoId") Long equipamentoId);

    Long countByDevolucaoIsNull();
}
