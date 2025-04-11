package com.senai.Cadastro.controller;

import com.senai.Cadastro.dto.LoginUsuarioDto;
import com.senai.Cadastro.dto.MensagemDto;
import com.senai.Cadastro.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class AutenticaçãoController {

    @Autowired
    UsuarioServico service;

    @PostMapping
    public String login(@ModelAttribute("loginDto") LoginUsuarioDto login){

        System.out.println(login.getLogin() + " " + login.getSenha());

        return "redirect:/home";
    }
    @GetMapping
    public String obterLogin(Model model){

        LoginUsuarioDto loginDto = new LoginUsuarioDto();
        loginDto.setLogin("pablo@senai.com");
        model.addAttribute("loginDto", loginDto);

        return "login";
    }
}
