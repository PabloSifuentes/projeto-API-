package com.senai.prova.services;

import com.senai.prova.dtos.PacienteDto;
import com.senai.prova.models.PacienteModel;
import com.senai.prova.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<PacienteDto> obterPaciente(){

        //--Obter os usuários do banco de dados
        List<PacienteModel> listaPaciente = pacienteRepository.findAll();

        //--Criar a lista DTO para realizar o retorno
        List<PacienteDto> lista = new ArrayList<>();

        //--Percorre a lista de usuários do banco e converter em uma lista de DTO
        for ( PacienteModel paciente :  listaPaciente ){

            //--Crio UM objeto DTO
            PacienteDto pacienteRetorno = new PacienteDto();

            //--Converto UM objeto model em UM objeto DTO
            pacienteRetorno.setId(paciente.getId());
            pacienteRetorno.setNome(paciente.getNome());
            pacienteRetorno.setEndereco(paciente.getEndereco());
            pacienteRetorno.setTelefone(paciente.getTelefone());
            pacienteRetorno.setEmail(paciente.getEmail());
            pacienteRetorno.setObservacao(paciente.getObservacao());

            //--Adciono o objeto DTO na lista de UsuarioDto
            lista.add(pacienteRetorno);
        }
        return lista;
    }

    public PacienteDto obterPacienteById(Long id){

        Optional<PacienteModel> pacienteOptional = pacienteRepository.findById(id);

        //--Se encontrar o usuário
        if (!pacienteOptional.isEmpty()){
            return new PacienteDto(pacienteOptional.get());
        }

        return new PacienteDto(pacienteOptional.get());
    }

    public Boolean adicionar(PacienteDto pacienteDto) {

        boolean temErro = false;
        PacienteModel pacienteModel = new PacienteModel();

        if (!temErro){
            pacienteModel.setNome(pacienteDto.getNome());
            pacienteModel.setEndereco(pacienteDto.getEndereco());
            pacienteModel.setTelefone(pacienteDto.getTelefone());
            pacienteModel.setEmail(pacienteDto.getEmail());
            pacienteModel.setObservacao(pacienteDto.getObservacao());

            pacienteRepository.save(pacienteModel);
            return true;
        }
        return false;
    }

    public boolean atualizar(Long id, PacienteDto alterar) {

        Optional<PacienteModel> existingPaciente = pacienteRepository.findById(id);
        if (existingPaciente.isEmpty()) {
            return false;
        }
        PacienteModel pacienteModel = existingPaciente.get();
        pacienteModel.setNome(alterar.getNome());
        pacienteModel.setEndereco(alterar.getEndereco());
        pacienteModel.setTelefone(alterar.getTelefone());
        pacienteModel.setEmail(alterar.getEmail());
        pacienteModel.setObservacao(alterar.getObservacao());

        pacienteRepository.save(pacienteModel);
        return true;

    }

    public boolean excluir(Long id){

        //--buscar no banco de dados o produto pelo ID
        Optional<PacienteModel> pacienteOptional = pacienteRepository.findById(id);

        //--Se encontrar o usuário
        if (!pacienteOptional.isEmpty()){
            pacienteRepository.delete(pacienteOptional.get());
            return true;
        }
        return false;
    }



}
