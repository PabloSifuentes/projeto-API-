package com.senai.Gerenciamento_EPI_SA.service;

import com.senai.Gerenciamento_EPI_SA.dto.PerfilRiscoDto;
import com.senai.Gerenciamento_EPI_SA.model.*;
import com.senai.Gerenciamento_EPI_SA.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilRiscoService {

    @Autowired private PerfilRiscoRepository perfilRiscoRepository;
    @Autowired private EquipamentoRepository equipamentoRepository;
    @Autowired private ColaboradoresRepository colaboradoresRepository;

    @Transactional
    public List<EquipamentoModel> recomendarEpis(Long colaboradorId) {
        ColaboradoresModel colaborador = colaboradoresRepository.findById(colaboradorId).orElseThrow();

        return perfilRiscoRepository.findByFuncaoAndSetor(
                        colaborador.getFuncao(),
                        colaborador.getSetor()
                )
                .stream()
                .findFirst()
                .map(PerfilRiscoModel::getEpisRecomendados)
                .orElse(Collections.emptyList());
    }

    @Transactional
    public void salvarPerfil(PerfilRiscoDto dto) {
        PerfilRiscoModel perfil = new PerfilRiscoModel();
        perfil.setFuncao(dto.getFuncao());  // Usando funcao
        perfil.setSetor(dto.getSetor());
        perfil.setRiscos(dto.getRiscosSelecionados());

        List<EquipamentoModel> epis = equipamentoRepository.findAllById(dto.getEpisIds());
        perfil.setEpisRecomendados(epis);

        perfilRiscoRepository.save(perfil);
    }

    public List<PerfilRiscoModel> listarTodosPerfis() {
        return perfilRiscoRepository.findAllWithEpis();
    }

    @Transactional
    public void excluir(Long id) {
        // Verifica se o perfil existe
        PerfilRiscoModel perfil = perfilRiscoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perfil não encontrado"));

        perfilRiscoRepository.delete(perfil);
    }

    public Optional<PerfilRiscoModel> buscarPorId(Long id) {
        return perfilRiscoRepository.findById(id);
    }

}