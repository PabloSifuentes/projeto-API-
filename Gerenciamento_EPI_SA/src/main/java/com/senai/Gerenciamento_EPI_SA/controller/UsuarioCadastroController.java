package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.UsuarioDto;
import com.senai.Gerenciamento_EPI_SA.dto.UsuarioSessaoDto;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioCadastroController {

    @GetMapping("/usuariocadastro")
    public String viewCadastroUsuario(Model model, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuarioDto", usuarioDto);

        return "usuariocadastro";
    }
}
