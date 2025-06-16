package com.senai.Gerenciamento_EPI_SA.repository;

import com.senai.Gerenciamento_EPI_SA.model.ColaboradoresModel;
import com.senai.Gerenciamento_EPI_SA.model.EquipamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ColaboradoresRepository extends JpaRepository<ColaboradoresModel, Long> {

    Optional<ColaboradoresModel> findByEmail(String email);

    Optional<ColaboradoresModel> findById(Long Id);

    boolean existsByEmail(String email);
}
