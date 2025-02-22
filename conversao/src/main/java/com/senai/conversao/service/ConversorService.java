package com.senai.conversao.service;

import com.senai.conversao.dto.RequisicaoDto;
import com.senai.conversao.dto.RespostaDto;
import com.senai.conversao.manipuladorGlobal.SuporteTipoConversao;
import org.springframework.stereotype.Service;

@Service
public class ConversorService {

    public RespostaDto realizarConversao(RequisicaoDto dados) {
        RespostaDto resposta = new RespostaDto();

        //Lógica de conversão.
        switch (dados.getTipoConversao()) {
            case "cm-m":
                resposta.setValorConvertido(dados.getValor() / 100);
                resposta.setValorOriginal(dados.getValor());
                resposta.setTipoConversao(dados.getTipoConversao());
                return resposta;
            case "m-cm":
                resposta.setValorConvertido(dados.getValor() * 100);
                resposta.setValorOriginal(dados.getValor());
                resposta.setTipoConversao(dados.getTipoConversao());
                return resposta;
            case "kg-g":
                resposta.setValorConvertido(dados.getValor() * 1000);
                resposta.setValorOriginal(dados.getValor());
                resposta.setTipoConversao(dados.getTipoConversao());
                return resposta;
            case "g-kg":
                resposta.setValorConvertido(dados.getValor() / 1000);
                resposta.setValorOriginal(dados.getValor());
                resposta.setTipoConversao(dados.getTipoConversao());
                return resposta;
            case "c-f":
                resposta.setValorConvertido((dados.getValor() * 9 / 5) + 32);
                resposta.setValorOriginal(dados.getValor());
                resposta.setTipoConversao(dados.getTipoConversao());
                return resposta;
            case "f-c":
                resposta.setValorConvertido((dados.getValor() - 32) * 0.55);
                resposta.setValorOriginal(dados.getValor());
                resposta.setTipoConversao(dados.getTipoConversao());
                return resposta;
            default://Verifiar se o tipo de conversão é válido.
                    throw new SuporteTipoConversao("Tipo de conversão inválido. Use um dos seguintes: cm-m, m-cm, kg-g, g-kg, c-f, f-c.");
        }
    }
}
