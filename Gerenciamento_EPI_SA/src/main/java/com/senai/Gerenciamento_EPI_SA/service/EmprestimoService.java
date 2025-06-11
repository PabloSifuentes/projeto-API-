package com.senai.Gerenciamento_EPI_SA.service;

import com.senai.Gerenciamento_EPI_SA.dto.EmprestimoDto;
import com.senai.Gerenciamento_EPI_SA.model.ColaboradoresModel;
import com.senai.Gerenciamento_EPI_SA.model.EmprestimoModel;
import com.senai.Gerenciamento_EPI_SA.model.EquipamentoModel;
import com.senai.Gerenciamento_EPI_SA.repository.ColaboradoresRepository;
import com.senai.Gerenciamento_EPI_SA.repository.EmprestimoRepository;
import com.senai.Gerenciamento_EPI_SA.repository.EquipamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @Autowired
    ColaboradoresRepository colaboradoresRepository;

    public List<EmprestimoDto> obterEmprestimos(){

        List<EmprestimoModel> listaEmprestimo = emprestimoRepository.findAll();
        List<EmprestimoDto> listaEmprestimoDto = new ArrayList<>();

        for ( EmprestimoModel emprestimoModel : listaEmprestimo){
            EmprestimoDto emprestimoDto = new EmprestimoDto(emprestimoModel);
            listaEmprestimoDto.add(emprestimoDto);
        }
        return listaEmprestimoDto;
    }

    public boolean criarEmprestimos(EmprestimoDto emprestimoDto) {

            Optional<ColaboradoresModel> colaboradorOP = colaboradoresRepository.findById(emprestimoDto.getColaboradorId());
            if (!colaboradorOP.isEmpty()) {
                Optional<EquipamentoModel> equipamentoOP = equipamentoRepository.findById(emprestimoDto.getEquipamentoId());
                if (!equipamentoOP.isEmpty()) {
                    EmprestimoModel emprestimoModel = new EmprestimoModel(emprestimoDto, equipamentoOP.get(), colaboradorOP.get());
                    emprestimoRepository.save(emprestimoModel);
                    return true;
                }
            }
            return false;
    }

    public boolean atualizarEmprestimo(Long id, EmprestimoDto emprestimos){

        Optional<EmprestimoModel> emprestimoOP = emprestimoRepository.findById(id);
        if (emprestimoOP.isPresent()){
            Optional<ColaboradoresModel> colaboradorOP = colaboradoresRepository.findById(emprestimos.getColaboradorId());
            if (colaboradorOP.isPresent()){
                Optional<EquipamentoModel> equipamentoOP = equipamentoRepository.findById(emprestimos.getEquipamentoId());
                if (equipamentoOP.isPresent()){

                    EmprestimoModel emprestimoModel = emprestimoOP.get();

                    emprestimoModel.setColaborador(colaboradorOP.get());
                    emprestimoModel.setEquipamento(equipamentoOP.get());
                    emprestimoModel.setDevolucao(emprestimos.getDevolucao());
                    emprestimoModel.setObservacao(emprestimos.getObservacao());
                    emprestimoRepository.save(emprestimoModel);
                    return  true;
                }
            }
        }
        return false;
    }

    public EmprestimoDto obterEmprestimoPorId(Long id){
        Optional<EmprestimoModel> emprestimoOP = emprestimoRepository.findById(id);
        if (emprestimoOP.isPresent()){
            return new EmprestimoDto(emprestimoOP.get());
        }
        return new EmprestimoDto();
    }

    public boolean remover(Long id){
        //--buscar no banco de dados o produto pelo ID
        Optional<EmprestimoModel> emprestimoOptional = emprestimoRepository.findById(id);

        //--Se encontrar o usuário
        if (!emprestimoOptional.isEmpty()){
            emprestimoRepository.delete(emprestimoOptional.get());
            return true;
        }
        return false;
    }

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @Transactional
    public void registrarDevolucao(Long emprestimoId, String observacao) {

        EmprestimoModel emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        emprestimo.registrarDevolucao(observacao);
        emprestimoRepository.save(emprestimo);
    }
}
