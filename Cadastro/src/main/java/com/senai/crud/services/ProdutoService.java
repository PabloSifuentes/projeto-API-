package com.senai.crud.services;

import com.senai.crud.dtos.*;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.models.UsuarioModel;
import com.senai.crud.repositories.CategoriaRepository;
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
    CategoriaRepository categoriaRepository;

    public boolean adicionarProduto(ProdutoDto produto){

        //--inicializo as variáveis
        boolean temErro = false;
        Optional<CategoriaModel> categoriaOp;
        ProdutoModel produtomodel2 = new ProdutoModel();

        //--Regras de negocio

        if (!temErro){
            if (produto.getPreco() <= 0 || produto.getQuantidadeEmEstoque() < 0){
                temErro = true;
            }
        }

        if (!temErro){
            //--se não tem erro!
            categoriaOp = categoriaRepository.findByid(produto.getCategoriaid());
            if (categoriaOp.isEmpty()){
                temErro = true;
            }
        }


        //--infinitas regras de negocio

        if (!temErro){

            ProdutoModel produtoModel = new ProdutoModel();
            produtoModel.setNome(produto.getNome());
            produtoModel.setDescricao(produto.getDescricao());
            produtoModel.setPreco(produto.getPreco());
            produtoModel.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());
            produtoModel.setCategoriaModel(produtomodel2.getCategoriaModel());
            produtoRepository.save(produtoModel);

            MensagemDto mensagem = new MensagemDto();
            mensagem.setMensagem("Cadastro com sucesso!");
            return true;
        }

        return false;
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

    public ProdutoAtualizarDto obterProdutoParaEdicao(Long id) {
        Optional<ProdutoModel> produtoOP = produtoRepository.findById(id);
        if (!produtoOP.isPresent()){
            //--quando não encontra retorna um objeto com id ZERO
            return new ProdutoAtualizarDto(0L);
        }
        return new ProdutoAtualizarDto(produtoOP.get());

    }

    public boolean atualizarProduto(Long id, ProdutoAtualizarDto produtoDto) {

        MensagemDto mensagem = new MensagemDto();

        Optional<ProdutoModel> existingProduto = produtoRepository.findByid(id);
        if (existingProduto.isEmpty()) {
            mensagem.setMensagem("Erro: Produto não encontrado para atualização.");
            mensagem.setSucesso(false);
            return false;
        }

        if(produtoDto.getPreco() <= 0 || produtoDto.getQuantidadeEmEstoque() < 0){
            return false;
        }

            ProdutoModel produtoModel = existingProduto.get();
            produtoModel.setNome(produtoDto.getNome());
            produtoModel.setDescricao(produtoDto.getDescricao());
            produtoModel.setPreco(produtoDto.getPreco());
            produtoModel.setQuantidadeEmEstoque(produtoDto.getQuantidadeEmEstoque());
            produtoRepository.save(produtoModel);
            mensagem.setMensagem("Produto atualizado com sucesso!");
            mensagem.setSucesso(true);
            return true;
    }

    public MensagemDto deletTask(Long id){

        MensagemDto mensagem = new MensagemDto();
        mensagem.setMensagem("Erro ao excluir");
        mensagem.setSucesso(false);

        //--buscar no banco de dados o usuário pelo ID
        Optional<ProdutoModel> produtoOptional = produtoRepository.findById(id);

        //--Se encontrar o usuário
        if (produtoOptional.isPresent()){

            produtoRepository.delete(produtoOptional.get());

            mensagem.setMensagem("Sucesso ao excluir o usuário");
            mensagem.setSucesso(true);

        }

        return mensagem;
    }
}
