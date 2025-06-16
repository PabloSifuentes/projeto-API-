package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.EmprestimoDto;
import com.senai.Gerenciamento_EPI_SA.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/emprestimos")
public class DevolucaoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping("/{id}/devolver")
    public String showDevolucaoForm(@PathVariable Long id, Model model) {
        EmprestimoDto emprestimo = emprestimoService.obterEmprestimoPorId(id);
        model.addAttribute("emprestimo", emprestimo);
        return "devolucao";
    }

    @PostMapping("/{id}/devolver")
    public String registrarDevolucao(@PathVariable Long id,
                                     @RequestParam(required = false) String observacao,
                                     RedirectAttributes redirectAttributes) {
        try {
            emprestimoService.registrarDevolucao(id, observacao);
            redirectAttributes.addFlashAttribute("success", "Devolução registrada com sucesso!");

            // Forçar limpeza do cache
            redirectAttributes.addAttribute("refresh", System.currentTimeMillis());

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao registrar devolução: " + e.getMessage());
        }
        return "redirect:/listaemprestimo";
    }
}