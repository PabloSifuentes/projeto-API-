package com.senai.Gerenciamento_EPI_SA.service;

import com.senai.Gerenciamento_EPI_SA.dto.ColaboradoresDto;
import com.senai.Gerenciamento_EPI_SA.model.ColaboradoresModel;
import com.senai.Gerenciamento_EPI_SA.repository.ColaboradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradoresService {

   @Autowired
    ColaboradoresRepository colaboradoresRepository;

    public List<ColaboradoresDto> obterColaboradores(){

        List<ColaboradoresModel> listaColaboradores = colaboradoresRepository.findAll();
        List<ColaboradoresDto> listaColaboradoresDto = new ArrayList<>();

        for ( ColaboradoresModel colaboradoresModel : listaColaboradores){
            ColaboradoresDto colaboradoresDto = new ColaboradoresDto(colaboradoresModel);
            listaColaboradoresDto.add(colaboradoresDto);
        }
        return listaColaboradoresDto;
    }

    public boolean criarColaborador(ColaboradoresDto colaboradoresDto) {
        // Verifica campos obrigatórios
        if (colaboradoresDto.getNome() == null || colaboradoresDto.getNome().isEmpty() ||
                colaboradoresDto.getEmail() == null || colaboradoresDto.getEmail().isEmpty() ||
                colaboradoresDto.getFuncao() == null || colaboradoresDto.getFuncao().isEmpty() ||
                colaboradoresDto.getNascimento() == null ||
                colaboradoresDto.getSetor() == null || colaboradoresDto.getSetor().isEmpty()) {
            return false;
        }

        // Verifica se email já existe
        if (colaboradoresRepository.existsByEmail(colaboradoresDto.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        ColaboradoresModel colaboradoresModel = new ColaboradoresModel(colaboradoresDto);
        colaboradoresRepository.save(colaboradoresModel);
        return true;
    }

    public boolean atualizarColaborador(Long id, ColaboradoresDto colaboradores){
        Optional<ColaboradoresModel> colaboradorOP = colaboradoresRepository.findById(id);
        if (colaboradorOP.isPresent()){
            colaboradorOP.get().setNome(colaboradores.getNome());
            colaboradorOP.get().setEmail(colaboradores.getEmail());
            colaboradorOP.get().setFuncao(colaboradores.getFuncao());
            colaboradorOP.get().setNascimento(colaboradores.getNascimento());
            colaboradoresRepository.save(colaboradorOP.get());
            return  true;
        }
        return false;
    }

    public ColaboradoresDto obterColaboradoresId(Long id){
        Optional<ColaboradoresModel> colaboradorOp = colaboradoresRepository.findById(id);
        if (colaboradorOp.isPresent()){
            return new ColaboradoresDto(colaboradorOp.get());
        }
        return new ColaboradoresDto();
    }

    public ColaboradoresDto buscarColaboradorEmail(String email){
        ColaboradoresDto colaboradoresDto = new ColaboradoresDto();
        String string = "";
        colaboradoresDto.setEmail(string);
        colaboradoresRepository.findByEmail(email);

        for (ColaboradoresModel userModel : colaboradoresRepository.findAll()){
            if (userModel.getEmail().equals(email)){
                colaboradoresDto.setNome(userModel.getNome());
                colaboradoresDto.setEmail(userModel.getEmail());
            }
        }
        return colaboradoresDto;
    }

    public boolean remover(Long id){
        //--buscar no banco de dados o produto pelo ID
        Optional<ColaboradoresModel> colaboradoresOptional = colaboradoresRepository.findById(id);

        //--Se encontrar o usuário
        if (!colaboradoresOptional.isEmpty()){
            colaboradoresRepository.delete(colaboradoresOptional.get());
            return true;
        }
        return false;
    }
}
