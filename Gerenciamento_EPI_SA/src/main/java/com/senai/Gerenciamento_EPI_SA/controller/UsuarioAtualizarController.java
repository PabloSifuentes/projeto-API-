package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.UsuarioAtualizarDto;
import com.senai.Gerenciamento_EPI_SA.dto.UsuarioSessaoDto;
import com.senai.Gerenciamento_EPI_SA.service.UsuarioService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsuarioAtualizarController {

    @Autowired
    UsuarioService service;

    @GetMapping("/{id}")
    public String obterUsuario(Model model, @PathVariable Long id, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        UsuarioAtualizarDto usuarioCadastroDto = service.buscarUsuarioId(id);

        if (usuarioCadastroDto.getId() == 0){
            //--Não encontrou o usuário!
            return "redirect:/usuariolista";
        }
        model.addAttribute("usuarioAtualizarDto", usuarioCadastroDto);
        return "usuarioatualizar";
    }
}
