package com.senai.crud.controllers;


import com.senai.crud.dtos.ListaProdutosDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdutoListaController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtolista")
    public String obterListaProduto(Model model){

        List<ListaProdutosDto> listaProdutosDtos = produtoService.listarProdutos();
        model.addAttribute("listaProdutosDtos", listaProdutosDtos);

        return "produtolista";
    }
}
