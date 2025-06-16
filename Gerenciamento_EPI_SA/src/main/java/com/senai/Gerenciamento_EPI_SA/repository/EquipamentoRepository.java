package com.senai.Gerenciamento_EPI_SA.repository;

import com.senai.Gerenciamento_EPI_SA.model.EquipamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoModel, Long> {

}
