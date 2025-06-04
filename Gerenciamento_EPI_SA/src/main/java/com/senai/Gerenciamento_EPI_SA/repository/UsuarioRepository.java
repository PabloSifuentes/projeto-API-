package com.senai.Gerenciamento_EPI_SA.repository;

import com.senai.Gerenciamento_EPI_SA.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByEmail(String email);

}
