package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class DevolucaoController {

    @Autowired
    EmprestimoService emprestimoService;

    public DevolucaoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/emprestimos/{id}/devolver")
    public String registrarDevolucao(@PathVariable Long id, @RequestParam(required = false) String observacao, RedirectAttributes redirectAttributes) {

        try {
            emprestimoService.registrarDevolucao(id, observacao);
            redirectAttributes.addFlashAttribute("success", "Devolução registrada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao registrar devolução: " + e.getMessage());
        }
        return "redirect:/emprestimos";
    }
}
