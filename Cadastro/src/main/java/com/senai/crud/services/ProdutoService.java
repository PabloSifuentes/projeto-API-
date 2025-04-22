package com.senai.crud.services;

import com.senai.crud.dtos.ListaProdutosDto;
import com.senai.crud.dtos.MensagemDto;
import com.senai.crud.dtos.ProdutoAtualizarDto;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.repositories.ProdutoRepository;
import com.senai.crud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<ListaProdutosDto> listarProdutos(){



    }

    public boolean atualizarProduto(Long id, ProdutoAtualizarDto produtoDto){




    }

    public MensagemDto deletTask(Long id){

        Optional<ProdutoModel> produtoOptional = produtoRepository.findByid(id);

        produtoOptional.ifPresent(produtoModel -> produtoRepository.delete(produtoModel));

        MensagemDto mensagem = new MensagemDto();
        mensagem.setMensagem("Sucesso ao excluir o produto");
        mensagem.setSucesso(true);

        if (produtoOptional.isEmpty()) {
            mensagem.setMensagem("Erro ao excluir");
            mensagem.setSucesso(false);
            return mensagem;
        }
        return mensagem;
    }
}
