package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.EquipamentoDto;
import com.senai.Gerenciamento_EPI_SA.dto.UsuarioSessaoDto;
import com.senai.Gerenciamento_EPI_SA.service.EquipamentoService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/listaequipamento")
public class ListaEquipamentoController {

    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping
    public String exibeAlteraEquipamento(Model model, HttpServletRequest request) {

        //--Fazer: Validar sessão
        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);
        if (usuarioSessao.getId() == 0L) {
            return "redirect:/login";
        }

        List<EquipamentoDto> equipamentos = equipamentoService.obterEquipamentos();
        model.addAttribute("equipamentos", equipamentos);
        return "listaequipamento";
    }
}
