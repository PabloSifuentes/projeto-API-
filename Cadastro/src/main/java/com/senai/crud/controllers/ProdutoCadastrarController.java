package com.senai.crud.controllers;

import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastrodeproduto")
public class ProdutoCadastrarController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public String obterCadastro(Model model){

        ProdutoDto cadastroDto = new ProdutoDto();
        model.addAttribute("cadastroDto", cadastroDto);

        return "cadastrodeproduto";
    }
}
