package com.senai.crud.controllers;

import com.senai.crud.ControleSessao;
import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ListaCategoriasDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.services.ProdutoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/produtocadastrar")
public class ProdutoCadastrarController {

    @Autowired
    CategoriaService service;

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public String exibirFormularioCadastro(Model model, HttpServletRequest request) {

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //Não esta logado! voltar para login
            return "redirect:/login";
        }

        ProdutoDto produtoDto = new ProdutoDto();

        List<ListaCategoriasDto> listaCategorias = service.listarCategorias();

        model.addAttribute("listaCategorias", listaCategorias);
        // Adiciona um novo ProdutoDto vazio ao modelo
        model.addAttribute("produtoDto", new ProdutoDto());
        return "produtocadastrar";
    }

    @PostMapping
    public String processarCadastro(ProdutoDto produtoDto) {
        produtoService.adicionarProduto(produtoDto);
        return "redirect:/produtolista";
    }
}