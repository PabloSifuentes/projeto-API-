package com.senai.Cadastro.controller;

import com.senai.Cadastro.dto.MensagemDto;
import com.senai.Cadastro.dto.RequisicaoDto;
import com.senai.Cadastro.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class CadastroController {

    @Autowired
    UsuarioServico usuarioServico;

    @GetMapping
    public String obterCadastro(Model model){

        RequisicaoDto cadastroDto = new RequisicaoDto();
        model.addAttribute("cadastroDto", cadastroDto);

        return "Register";
    }

    @PostMapping
    public String realizarCadastro(@ModelAttribute("cadastroDto") RequisicaoDto cadastroDto){

        MensagemDto mensagem = usuarioServico.adicionarUsuario(cadastroDto);

        if (mensagem.isSucesso()){
            return "redirect:/cadastro?sucesso";
        }
        return "redirect:/cadastro?erro";
    }


}
