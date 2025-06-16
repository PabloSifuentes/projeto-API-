package com.senai.Gerenciamento_EPI_SA.service;

import com.senai.Gerenciamento_EPI_SA.dto.EmprestimoDto;
import com.senai.Gerenciamento_EPI_SA.exception.InvalidOperationException;
import com.senai.Gerenciamento_EPI_SA.model.ColaboradoresModel;
import com.senai.Gerenciamento_EPI_SA.model.EmprestimoModel;
import com.senai.Gerenciamento_EPI_SA.model.EquipamentoModel;
import com.senai.Gerenciamento_EPI_SA.repository.ColaboradoresRepository;
import com.senai.Gerenciamento_EPI_SA.repository.EmprestimoRepository;
import com.senai.Gerenciamento_EPI_SA.repository.EquipamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @Autowired
    ColaboradoresRepository colaboradoresRepository;

    public List<EmprestimoDto> obterEmprestimos() {
        // Força uma consulta fresca ao banco
        List<EmprestimoModel> listaEmprestimo = emprestimoRepository.findAll();

        return listaEmprestimo.stream()
                .map(emprestimo -> {
                    EmprestimoDto dto = new EmprestimoDto(emprestimo);
                    // Debug: verifique os dados
                    System.out.println("ID: " + dto.getId() +
                            " | Devolução: " + dto.getDevolucao());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean criarEmprestimos(EmprestimoDto emprestimoDto) {

        try {
            Optional<ColaboradoresModel> colaborador = colaboradoresRepository.findById(emprestimoDto.getColaboradorId());
            Optional<EquipamentoModel> equipamento = equipamentoRepository.findById(emprestimoDto.getEquipamentoId());

            if (colaborador.isEmpty() || equipamento.isEmpty()) {
                throw new IllegalArgumentException("Colaborador ou equipamento não encontrado");
            }

            // Verifica se há empréstimos ativos para este equipamento
            List<EmprestimoModel> emprestimosAtivos = emprestimoRepository.findEmprestimosAtivosPorEquipamento(equipamento.get().getId());
            if (!emprestimosAtivos.isEmpty()) {
                throw new IllegalStateException("Equipamento já está emprestado");
            }

            EmprestimoModel emprestimo = new EmprestimoModel();
            emprestimo.setColaborador(colaborador.get());
            emprestimo.setEquipamento(equipamento.get());
            emprestimo.setObservacao(emprestimoDto.getObservacao());
            emprestimoRepository.save(emprestimo);

        }
        catch (Exception e) {
            throw new InvalidOperationException("Falha ao criar empréstimo: " + e.getMessage(), e);
        }
        return true;
    }

    public boolean atualizarEmprestimo(Long id, EmprestimoDto emprestimos){

        Optional<EmprestimoModel> emprestimoOP = emprestimoRepository.findById(id);
        if (emprestimoOP.isPresent()){
            Optional<ColaboradoresModel> colaboradorOP = colaboradoresRepository.findById(emprestimos.getId());
            if (colaboradorOP.isPresent()){
                Optional<EquipamentoModel> equipamentoOP = equipamentoRepository.findById(emprestimos.getId());
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
        EmprestimoModel emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        // Verifica se já foi devolvido
        if (emprestimo.getDevolucao() != null) {
            throw new IllegalStateException("Este empréstimo já foi devolvido");
        }

        // Atualiza a data de devolução
        emprestimo.setDevolucao(LocalDate.now());

        // Atualiza a observação se fornecida
        if (observacao != null && !observacao.trim().isEmpty()) {
            emprestimo.setObservacao(observacao);
        }

        // Libera o equipamento
        if (emprestimo.getEquipamento() != null) {
            emprestimo.getEquipamento().setDisponivel(true);
            equipamentoRepository.save(emprestimo.getEquipamento());
        }

        // Salva as alterações
        emprestimoRepository.save(emprestimo);

        // DEBUG: Verifique se está salvando corretamente
        System.out.println("Devolução registrada - ID: " + emprestimoId +
                " | Data: " + emprestimo.getDevolucao());
    }

    public Long contarEmprestimosAtivos() {
        return emprestimoRepository.countByDevolucaoIsNull();
    }
}
