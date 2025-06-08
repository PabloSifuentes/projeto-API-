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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alteraequipamento")
public class AtualizarEquipamentoController {

    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping("/{id}")
    public String exibeAlteraEquipamento(Model model, HttpServletRequest request, @PathVariable Long id){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);
        if (usuarioSessao.getId() == 0L) {
            return "redirect:/login";
        }

        EquipamentoDto equipamentoDto = equipamentoService.obterEquipamentoId(id);
        if (equipamentoDto == null) {
            return "redirect:/listaequipamento";
        }

        model.addAttribute("equipamentoDto", equipamentoDto);
        return "alteraequipamento";
    }
}
