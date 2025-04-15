package com.senai.Cadastro.controller;

import com.senai.Cadastro.dto.ListaUsuarioDto;
import com.senai.Cadastro.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userList")
public class UserListController {

    @Autowired
    UsuarioServico usuarioServico;

    @GetMapping
    public String obterLista(Model model){

        List<ListaUsuarioDto> listaUsuarioDto = usuarioServico.listarUsuarios();
        model.addAttribute("consultaUsuarioDto", listaUsuarioDto);

        return "lista";
    }
}
