package com.senai.crud.controllers;

import com.senai.crud.ControleSessao;
import com.senai.crud.dtos.*;
import com.senai.crud.services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class AuthController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterLogin(Model model){

        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto",loginDto);

        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute("loginDto") LoginDto login, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = service.logar(login);

        if (usuarioSessao.getId() != 0L){
            ControleSessao.registrar(request, usuarioSessao);
            return "redirect:/home";
        }
        return "redirect:/login?erro";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){

        ControleSessao.encerrar(request);
        return "redirect:/login";
    }

}
