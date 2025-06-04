package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.ListaUsuariosDto;
import com.senai.Gerenciamento_EPI_SA.dto.UsuarioSessaoDto;
import com.senai.Gerenciamento_EPI_SA.service.UsuarioService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioListaController {

    @Autowired
    UsuarioService service;

    @GetMapping("/usuariolista")
    public String obterUsuarioLista(Model model, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        List<ListaUsuariosDto> listaUsuariosDto = service.listarUsuarios();
        model.addAttribute("listaUsuariosDto",listaUsuariosDto);

        return "usuariolista";
    }
}
