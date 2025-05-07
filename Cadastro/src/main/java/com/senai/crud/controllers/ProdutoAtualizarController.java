package com.senai.crud.controllers;

import com.senai.crud.dtos.ProdutoAtualizarDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtoatualizar")
public class ProdutoAtualizarController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/{id}")
    public String obterProduto(Model model, @PathVariable Long id){

        ProdutoAtualizarDto produtoCadastroDto = produtoService.obterProdutoParaEdicao(id);

        if(produtoCadastroDto.getId() == 0 || produtoCadastroDto.getId() == null){
            return "redirect:/produtolista";
        }
        model.addAttribute("produtoAtualizarDto", produtoCadastroDto);
        return "produtoatualizar";
    }

}
