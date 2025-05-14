package com.senai.crud.services;

import com.senai.crud.dtos.ListaUsuariosDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.models.UsuarioModel;
import com.senai.crud.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<ProdutoDto> obterProduto(){

        List<ProdutoModel> listaProdutos = repository.findAll();
        List<ProdutoDto> lista = new ArrayList<>();

        for (ProdutoModel produto : listaProdutos){

            ProdutoDto produtoRetorno = new ProdutoDto();

            produtoRetorno.setId(produto.getId());
            produtoRetorno.setNome(produto.getNome());
            produtoRetorno.setDescricao(produto.getDescricao());
            produtoRetorno.setPreco(produto.getPreco());
            produtoRetorno.setQuantidade(produto.getQuantidade());
            lista.add(produtoRetorno);
        }
        return lista;
    }



}
