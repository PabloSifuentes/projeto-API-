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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/listaemprestimo")
public class ListaemprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping
    public String exibeAlteraEmprestimo(Model model, HttpServletRequest request) {

        //--Fazer: Validar sessão
        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);
        if (usuarioSessao.getId() == 0L) {
            return "redirect:/login";
        }

        List<EmprestimoDto> emprestimos = emprestimoService.obterEmprestimos();
        model.addAttribute("emprestimos", emprestimos);
        return "listaemprestimo";
    }
}
