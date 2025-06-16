package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.EmprestimoDto;
import com.senai.Gerenciamento_EPI_SA.dto.UsuarioSessaoDto;
import com.senai.Gerenciamento_EPI_SA.service.EmprestimoService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizaemprestimo")
public class VisualizaEmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping("/{id}")
    public String visualizaEmprestimo(Model model, HttpServletRequest request, @PathVariable Long id) {

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);
        if (usuarioSessao.getId() == 0L) {
            return "redirect:/login";
        }

        EmprestimoDto emprestimoDto = emprestimoService.obterEmprestimoPorId(id);
        if (emprestimoDto.getId() == null) {
            return "redirect:/listaemprestimo";
        }

        model.addAttribute("emprestimoDto", emprestimoDto);
        return "visualizaemprestimo";
    }
}
