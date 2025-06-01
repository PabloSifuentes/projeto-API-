package com.senai.prova.services;

import com.senai.prova.dtos.MedicoDto;
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

    public List<MedicoDto> obterMedico(){

        //--Obter os usuários do banco de dados
        List<MedicoModel> listaMedicos = medicoRepository.findAll();

        //--Criar a lista DTO para realizar o retorno
        List<MedicoDto> lista = new ArrayList<>();

        //--Percorre a lista de usuários do banco e converter em uma lista de DTO
        for ( MedicoModel medico :  listaMedicos ){

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

    public MedicoDto obterMedicoById(Long id){

        Optional<MedicoModel> medicoOptional = medicoRepository.findById(id);

        //--Se encontrar o usuário
        if (!medicoOptional.isEmpty()){
            return new MedicoDto(medicoOptional.get());
        }

        return new MedicoDto(medicoOptional.get());
    }

    public Boolean adicionar(MedicoDto medicoDto) {

        boolean temErro = false;
        MedicoModel medicoModel = new MedicoModel();




        if (!temErro){
            medicoModel.setNome(medicoDto.getNome());
            medicoModel.setEspecialidade(medicoDto.getEspecialidade());
            medicoRepository.save(medicoModel);
            return true;
    }
        return false;
    }

    public boolean atualizar(Long id, MedicoDto alterar) {

        Optional<MedicoModel> existingMedico = medicoRepository.findById(id);
        if (existingMedico.isEmpty()) {
            return false;
        }
        MedicoModel medicoModel = existingMedico.get();
        medicoModel.setNome(alterar.getNome());
        medicoModel.setEspecialidade(alterar.getEspecialidade());
        medicoRepository.save(medicoModel);
        return true;

    }

    public boolean excluir(Long id){

        //--buscar no banco de dados o produto pelo ID
        Optional<MedicoModel> medicoOptional = medicoRepository.findById(id);

        //--Se encontrar o usuário
        if (!medicoOptional.isEmpty()){
            medicoRepository.delete(medicoOptional.get());
            return true;
        }
        return false;
    }
}
