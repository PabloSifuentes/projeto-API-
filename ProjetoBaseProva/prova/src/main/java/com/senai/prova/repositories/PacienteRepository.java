package com.senai.prova.repositories;

import com.senai.prova.models.MedicoModel;
import com.senai.prova.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {

    Optional<PacienteModel> findById (Long id);
}
