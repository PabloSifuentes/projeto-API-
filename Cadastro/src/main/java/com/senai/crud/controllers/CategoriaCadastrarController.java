package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.services.CategoriaService;
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
    public String exibirFormularioCategoria (Model model){

        model.addAttribute("categoriaDto", new CategoriaDto());
        return "categoriaCadastrar";
    }

    @PostMapping
    public String cadastrarCategoria (CategoriaDto categoria){

        service.cadastrarCategoria(categoria);
        return "redirect:/categorialista";
    }

}
