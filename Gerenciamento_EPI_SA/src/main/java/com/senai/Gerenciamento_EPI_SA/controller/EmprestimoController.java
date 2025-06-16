package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.EmprestimoDto;
import com.senai.Gerenciamento_EPI_SA.exception.InvalidOperationException;
import com.senai.Gerenciamento_EPI_SA.service.EmprestimoService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @PostMapping()
    public String cadastraEmprestimo(@ModelAttribute("emprestimoDto") EmprestimoDto emprestimoDto,
                                     HttpServletRequest request,
                                     RedirectAttributes redirectAttributes) {

        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }

        try {
            boolean retorno = emprestimoService.criarEmprestimos(emprestimoDto);
            if (retorno) {
                redirectAttributes.addFlashAttribute("sucesso", "Empréstimo cadastrado com sucesso!");
                return "redirect:/listaemprestimo";
            }
        } catch (InvalidOperationException ex) {
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Ocorreu um erro inesperado");
        }
        return "redirect:/cadastraemprestimo";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        boolean retorno = emprestimoService.remover(id);
        return retorno
                ? ResponseEntity.ok("Emprestimo excluído com sucesso")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao excluir");
    }
}
