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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/listaemprestimo")
public class ListaemprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public String exibeAlteraEmprestimo(Model model, HttpServletRequest request,
                                        @RequestParam(required = false) Long refresh) {
        // ... verificação de sessão ...

        // Forçar recarregamento dos dados se necessário
        List<EmprestimoDto> emprestimos = emprestimoService.obterEmprestimos();

        // DEBUG: Verifique os dados retornados
        if (!emprestimos.isEmpty()) {
            System.out.println("Primeiro empréstimo - Devolução: " +
                    emprestimos.get(0).getDevolucao());
        }

        model.addAttribute("emprestimos", emprestimos);
        return "listaemprestimo";
    }

    // Método auxiliar simplificado
    @ModelAttribute("formatarData")
    public String formatarData(LocalDate data) {
        return data != null ? data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";
    }
}
