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
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String autenticaLogin(@ModelAttribute("loginDto") LoginDto login, HttpServletRequest request){

        UsuarioSessaoDto sessao =  usuarioService.realizarLogin(login);

        System.out.println("usuario"+ login.getEmail() + " senha=" + login.getSenha());

        if (sessao.getId() != 0L){

            ControleSessao.registrar(request, sessao);

            return "redirect:/listamedico";
        }
        return "redirect:/login?erro";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){

        ControleSessao.encerrar(request);
        return "redirect:/login";

    }
}
