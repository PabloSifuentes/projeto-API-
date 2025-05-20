package com.senai.crud.controllers;


import com.senai.crud.ControleSessao;
import com.senai.crud.dtos.ListaProdutosDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.services.ProdutoService;
import jakarta.servlet.http.HttpServletRequest;
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
    public String obterListaProduto(Model model, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        List<ListaProdutosDto> listaProdutosDtos = produtoService.listarProdutos();
        model.addAttribute("listaProdutosDtos", listaProdutosDtos);

        return "produtolista";
    }
}
