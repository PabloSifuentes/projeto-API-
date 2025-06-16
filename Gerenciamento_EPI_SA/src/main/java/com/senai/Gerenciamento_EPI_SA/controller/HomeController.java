package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.UsuarioSessaoDto;
import com.senai.Gerenciamento_EPI_SA.service.EmprestimoService;
import com.senai.Gerenciamento_EPI_SA.service.EquipamentoService;
import com.senai.Gerenciamento_EPI_SA.service.PerfilRiscoService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PerfilRiscoService perfilRiscoService;

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping
    public String dashboard(Model model, HttpServletRequest request) {
        // Verificação de sessão
        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);
        if (usuarioSessao.getId() == 0) {
            return "redirect:/login";
        }

        // Dados para o dashboard
        model.addAttribute("nomeUsuario", usuarioSessao.getNome());
        model.addAttribute("perfisRisco", perfilRiscoService.listarTodosPerfis());
        model.addAttribute("totalEmprestimosAtivos", emprestimoService.contarEmprestimosAtivos());
        model.addAttribute("totalEquipamentos", equipamentoService.contarEquipamentos());

        return "home";
    }
}