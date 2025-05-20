package com.senai.crud.controllers;

import com.senai.crud.ControleSessao;
import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ListaCategoriasDto;
import com.senai.crud.dtos.ProdutoAtualizarDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.services.ProdutoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtoatualizar")
public class ProdutoAtualizarController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/{id}")
    public String obterProduto(Model model, @PathVariable Long id, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        ProdutoAtualizarDto produtoCadastroDto = produtoService.obterProdutoParaEdicao(id);
        List<ListaCategoriasDto> listaCategorias = categoriaService.listarCategorias();

        if(produtoCadastroDto.getId() == 0 || produtoCadastroDto.getId() == null){
            return "redirect:/produtolista";
        }
        model.addAttribute("listaCategorias", listaCategorias);
        model.addAttribute("produtoAtualizarDto", produtoCadastroDto);
        return "produtoatualizar";
    }

}
