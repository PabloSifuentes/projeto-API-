package com.senai.Cadastro.service;

import com.senai.Cadastro.dto.CadastroDto;
import com.senai.Cadastro.dto.RespostaDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroServico {
    List<CadastroDto> listaDeCadastro = new ArrayList<>();

    public boolean realizarCadastro(CadastroDto dados) {
        for(CadastroDto cadastroDentroDaLista : listaDeCadastro) {
            if(cadastroDentroDaLista.getId() == (dados.getId())) {
                RespostaDto resposta = new RespostaDto();
                resposta.setId(dados.getId());
                resposta.setUsuario(dados.getUsuario());
            }
        }
            return listaDeCadastro.add(dados);
    }
}