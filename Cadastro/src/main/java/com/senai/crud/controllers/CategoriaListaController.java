package com.senai.crud.controllers;

import com.senai.crud.dtos.ListaCategoriasDto;
import com.senai.crud.dtos.ListaUsuariosDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoriaListaController {

    @Autowired
    CategoriaService service;

    @GetMapping("/categorialista")
    public String obterCategoriaLista(Model model){

        List<ListaCategoriasDto> listaCategoriaDto = service.listarCategorias();
        model.addAttribute("listaCategoriasDto",listaCategoriaDto);

        return "categorialista";
    }
}
