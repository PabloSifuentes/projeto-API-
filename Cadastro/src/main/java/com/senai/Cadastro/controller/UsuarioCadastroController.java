package com.senai.Cadastro.controller;

import com.senai.Cadastro.dto.UsuarioCadastroDto;
import com.senai.Cadastro.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuariocadastrar")
public class UsuarioCadastroController {

    @Autowired
    UsuarioServico service;


    @GetMapping("/{id}")
    public String obterCadastro(Model model, @PathVariable Long id){

        UsuarioCadastroDto usuarioCadastroDto = service.buscarUsuarioPorId(id);
        model.addAttribute("usuarioCadastroDto", usuarioCadastroDto);
        return "usuarioatualizar";
    }

}
