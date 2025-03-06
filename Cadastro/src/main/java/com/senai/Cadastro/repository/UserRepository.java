package com.senai.Cadastro.repository;

import com.senai.Cadastro.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByLogin(String login);
}
