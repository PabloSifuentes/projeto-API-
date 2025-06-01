package com.senai.prova.repositories;

import com.senai.prova.models.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {

    Optional<MedicoModel> findById (Long id);
}
