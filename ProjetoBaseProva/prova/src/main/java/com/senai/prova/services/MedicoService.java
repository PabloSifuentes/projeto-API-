package com.senai.prova.services;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.exception.InvalidOperationException;
import com.senai.prova.models.MedicoModel;
import com.senai.prova.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
   
    @Autowired
    MedicoRepository medicoRepository;
    
    public List<MedicoDto> listarMedicos(){

        List<MedicoModel> listaMedico = medicoRepository.findAll();

        List<MedicoDto> lista = new ArrayList<>();

        for(MedicoModel medico : listaMedico){

            MedicoDto medicoRetorno = new MedicoDto();

            medicoRetorno.setId(medico.getId());
            medicoRetorno.setNome(medico.getNome());
            medicoRetorno.setEspecialidade(medico.getEspecialidade());

            lista.add(medicoRetorno);

        }
        return lista;
    }

    public boolean adicionarMedico(MedicoDto medico){

        MedicoModel medicoModel = new MedicoModel();
        medicoModel.setNome(medico.getNome());
        medicoModel.setEspecialidade(medico.getEspecialidade());

        medicoRepository.save(medicoModel);
        return true;

    }

    public boolean atualizarMedico( Long id, MedicoDto medicodto ){

        //--buscar no banco de dados a categoria pelo ID
        Optional<MedicoModel> medicoOptional = medicoRepository.findById(id);

        //--Se encontrar a categoria
        if (!medicoOptional.isEmpty()){

            //--Atualizar a descricao da categoria dentro do optional
            medicoOptional.get().setNome(medicodto.getNome());
            medicoOptional.get().setEspecialidade(medicodto.getEspecialidade());

            //--persistir usuário no banco de dados
            medicoRepository.save(medicoOptional.get());
            return true;
        }
        return false;
    }
    public boolean removerMedico(Long id){

        //--buscar no banco de dados o usuário pelo ID
        Optional<MedicoModel> medicoOptional = medicoRepository.findById(id);

        //--Se encontrar o usuário
        if (medicoOptional.isPresent()){

            medicoRepository.delete(medicoOptional.get());
            return true;
        }
        return false;
    }

    public List<MedicoDto> obterMedico(){

        //--Obter os usuários do banco de dados
        List<MedicoModel> listaMedico = medicoRepository.findAll();

        //--Criar a lista DTO para realizar o retorno
        List<MedicoDto> lista = new ArrayList<>();

        //--Percorre a lista de usuários do banco e converter em uma lista de DTO
        for ( MedicoModel medico :  listaMedico ){

            //--Crio UM objeto DTO
            MedicoDto medicoRetorno = new MedicoDto();

            //--Converto UM objeto model em UM objeto DTO
            medicoRetorno.setId(medico.getId());
            medicoRetorno.setNome(medico.getNome());
            medicoRetorno.setEspecialidade(medico.getEspecialidade());


            //--Adciono o objeto DTO na lista de UsuarioDto
            lista.add(medicoRetorno);
        }

        return lista;

    }

}
