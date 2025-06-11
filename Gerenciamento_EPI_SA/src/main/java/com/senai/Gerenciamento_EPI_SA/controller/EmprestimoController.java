package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.EmprestimoDto;
import com.senai.Gerenciamento_EPI_SA.service.EmprestimoService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @PostMapping()
    public String cadastraEmprestimo(@ModelAttribute("emprestimoDto") EmprestimoDto emprestimoDto, HttpServletRequest request) {

        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }

        boolean retorno = emprestimoService.criarEmprestimos(emprestimoDto);
        return retorno?"redirect:/listaemprestimo" : "redirect:/cadastraemprestimo?erro";
    }

    @PostMapping("/{id}")
    public String atualizaremprestimo(@ModelAttribute("emprestimoDto") EmprestimoDto alterar, @PathVariable Long id, HttpServletRequest request) {

        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }

        boolean retorno = emprestimoService.atualizarEmprestimo(id, alterar);
        return retorno ? "redirect:/listaemprestimo" : "redirect:/alteraemprestimo/" + id + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        boolean retorno = emprestimoService.remover(id);
        return retorno
                ? ResponseEntity.ok("Emprestimo excluído com sucesso")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao excluir");
    }
}
