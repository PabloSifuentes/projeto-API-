package com.senai.Gerenciamento_EPI_SA.service;

import com.senai.Gerenciamento_EPI_SA.dto.EquipamentoDto;
import com.senai.Gerenciamento_EPI_SA.model.EquipamentoModel;
import com.senai.Gerenciamento_EPI_SA.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    @Autowired
    EquipamentoRepository repository;

    public List<EquipamentoDto> obterEquipamentos(){

        List<EquipamentoModel> listaEquipamento = repository.findAll();
        List<EquipamentoDto> listaEquipamentoDto = new ArrayList<>();

        for ( EquipamentoModel equipamentoModelModel : listaEquipamento){
            EquipamentoDto equipamentoDtoDto = new EquipamentoDto(equipamentoModelModel);
            listaEquipamentoDto.add(equipamentoDtoDto);
        }
        return listaEquipamentoDto;
    }

    public boolean criarEquipamento(EquipamentoDto EquipamentoDto){
        EquipamentoModel estadoModel = new EquipamentoModel(EquipamentoDto);
        repository.save(estadoModel);
        return true;
    }

    public boolean atualizarEquipamento(Long id, EquipamentoDto equipamento){
        Optional<EquipamentoModel> equipamentoOp = repository.findById(id);
        if (equipamentoOp.isPresent()){
            equipamentoOp.get().setDescricao(equipamento.getDescricao());
            equipamentoOp.get().setTipo(equipamento.getTipo());
            repository.save(equipamentoOp.get());
            return  true;
        }
        return false;
    }

    public EquipamentoModel obterEstadoPorId(Long id){
        Optional<EquipamentoModel> equipamentoOp = repository.findById(id);
        if (equipamentoOp.isPresent()){
            return equipamentoOp.get();
        }
        return new EquipamentoModel();
    }

    public EquipamentoDto obterEstadoId(Long id){
        Optional<EquipamentoModel> equipamentoOp = repository.findById(id);
        if (equipamentoOp.isPresent()){
            return new EquipamentoDto(equipamentoOp.get());
        }
        return new EquipamentoDto();
    }

    public boolean remover(Long id){
    //--buscar no banco de dados o produto pelo ID
    Optional<EquipamentoModel> equipamentoOptional = repository.findById(id);

    //--Se encontrar o usuário
        if (!equipamentoOptional.isEmpty()){
        repository.delete(equipamentoOptional.get());
        return true;
    }
        return false;
}
}
