package com.senai.Cadastro.controller;

import com.senai.Cadastro.dto.UsuarioAtualizarDto;
import com.senai.Cadastro.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userUpdate")
public class UsuarioAtualizarController {

    @Autowired
    UsuarioServico service;

    @GetMapping("/{id}")
    public String obterCadastro(Model model, @PathVariable Long id){

        UsuarioAtualizarDto usuarioCadastroDto = service.buscarUsuarioPorId(id);
        model.addAttribute("usuarioAtualizarDto", usuarioCadastroDto);

        return "userUpdate";
    }
}
