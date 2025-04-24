package com.senai.crud.services;

import com.senai.crud.dtos.ListaProdutosDto;
import com.senai.crud.dtos.MensagemDto;
import com.senai.crud.dtos.ProdutoAtualizarDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.models.UsuarioModel;
import com.senai.crud.repositories.ProdutoRepository;
import com.senai.crud.repositories.UsuarioRepository;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public MensagemDto adicionarProduto(ProdutoDto produto){

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome(produto.getNome());
        produtoModel.setDescricao(produto.getDescricao());
        produtoModel.setPreco(produto.getPreco());
        produtoModel.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());

        produtoRepository.save(produtoModel);

        MensagemDto mensagem = new MensagemDto();
        mensagem.setMensagem("Cadastro com sucesso!");
        mensagem.setSucesso(true);
        return mensagem;
    }



    public List<ListaProdutosDto> listarProdutos() {

        List<ProdutoModel> produtoList = produtoRepository.findAll();
        List<ListaProdutosDto> list = new ArrayList<>();

        for (ProdutoModel produtoModel : produtoList) {
            ListaProdutosDto returnProduto = new ListaProdutosDto();
            returnProduto.setId(produtoModel.getId());
            returnProduto.setNome(produtoModel.getNome());
            returnProduto.setDescricao(produtoModel.getDescricao());
            returnProduto.setPreco(produtoModel.getPreco());
            returnProduto.setQuantidadeEmEstoque(produtoModel.getQuantidadeEmEstoque());
            list.add(returnProduto);
        }
        return list;
    }

    public MensagemDto atualizarProduto(Long id, ProdutoAtualizarDto produtoDto) {

        Optional<ProdutoModel> existingProduto = produtoRepository.findByid(id);
        if (existingProduto.isEmpty()) {
            return new MensagemDto(false, "Erro: Produto não encontrado para atualização.");
        }

        try {
            ProdutoModel produtoModel = existingProduto.get();
            produtoModel.setNome(produtoDto.getNome());
            produtoModel.setDescricao(produtoDto.getDescricao());
            produtoModel.setPreco(produtoDto.getPreco());
            produtoModel.setQuantidadeEmEstoque(produtoDto.getQuantidadeEmEstoque());
            return new MensagemDto(true, "Produto atualizado com sucesso!");
        } catch (Exception e) {
            return new MensagemDto(false, "Erro ao inserir tarefa");
        }
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
