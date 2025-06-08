package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.UsuarioDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @GetMapping
    public String viewCadastro(Model model){

        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuarioDto",usuarioDto);

        return "cadastro";
    }
}
