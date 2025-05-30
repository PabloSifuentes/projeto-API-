package com.senai.prova.controllers;

import com.senai.prova.dtos.LoginDto;
import com.senai.prova.dtos.UsuarioSessaoDto;
import com.senai.prova.services.UsuarioService;
import com.senai.prova.session.ControleSessao;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping()
    public String exibeLogin(Model model,  HttpServletRequest request){
        
        //--Fazer: Limpar sessão        
        ControleSessao.encerrar(request);

        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        
        return "login";
    }
    
    
    @PostMapping()
    public String autenticaLogin(Model model, HttpServletRequest request){
        
        //--Fazer: validar sessão
        UsuarioSessaoDto usuarioSessao = usuarioService.realizarLogin((LoginDto) model);
        
        //--Fazer: Validar email e senha do usuário
        if (usuarioSessao.equals(((LoginDto) model).getSenha()) || usuarioSessao.equals(((LoginDto) model).getEmail())){
            ControleSessao.registrar(request, usuarioSessao);
            return "redirect:listamedico";
        }
        return "redirect:/login?erro";

    }
}
