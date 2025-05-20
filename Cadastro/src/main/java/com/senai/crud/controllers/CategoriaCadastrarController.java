package com.senai.crud.controllers;

import com.senai.crud.ControleSessao;
import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.services.CategoriaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoriaCadastrar")
public class CategoriaCadastrarController {

    @Autowired
    CategoriaService service;

    @GetMapping
    public String exibirFormularioCategoria (Model model, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        model.addAttribute("categoriaDto", new CategoriaDto());
        return "categoriaCadastrar";
    }

    @PostMapping
    public String cadastrarCategoria (CategoriaDto categoria){

        service.cadastrarCategoria(categoria);
        return "redirect:/categorialista";
    }

}
