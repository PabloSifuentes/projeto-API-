package com.senai.Cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoverPassword")
public class RecoverPasswordController {

    @GetMapping
    public String obterPassword(){
        return "recoverPassword";
    }
}
