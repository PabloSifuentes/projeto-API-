package com.senai.prova.repositories;

import com.senai.prova.models.UsuarioModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    
    //--Método para obter usuário filtrando pelo e-mail
     Optional<UsuarioModel> findByEmail(String email);
    
}
