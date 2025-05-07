package com.senai.crud.controllers;

import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtocadastrar")
public class ProdutoCadastrarController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String exibirFormularioCadastro(Model model) {
        // Adiciona um novo ProdutoDto vazio ao modelo
        model.addAttribute("produtoDto", new ProdutoDto());
        return "produtocadastrar";
    }

    @PostMapping
    public String processarCadastro(ProdutoDto produtoDto) {
        produtoService.adicionarProduto(produtoDto);
        return "redirect:/produtolista"; //
    }
}