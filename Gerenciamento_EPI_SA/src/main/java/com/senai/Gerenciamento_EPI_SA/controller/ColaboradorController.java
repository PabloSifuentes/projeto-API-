package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.ColaboradoresDto;
import com.senai.Gerenciamento_EPI_SA.dto.UsuarioSessaoDto;
import com.senai.Gerenciamento_EPI_SA.service.ColaboradoresService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    ColaboradoresService colaboradoresService;

    @PostMapping()
    public String cadastraColaborador(@ModelAttribute("colaboradoresDto") ColaboradoresDto colaboradoresDto, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);
        if (usuarioSessao.getId() == 0L) {
            return "redirect:/login";
        }

        try {
            boolean sucesso = colaboradoresService.criarColaborador(colaboradoresDto);
            if (sucesso) {
                redirectAttributes.addFlashAttribute("sucesso", "Colaborador cadastrado com sucesso!");
                return "redirect:/listacolaborador";
            } else {
                redirectAttributes.addFlashAttribute("erro", "Preencha todos os campos obrigatórios!");
                return "redirect:/cadastracolaborador";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao cadastrar: " + e.getMessage());
            return "redirect:/cadastracolaborador";
        }
    }

    @PostMapping("/{id}")
    public String atualizaColaborador(@ModelAttribute("colaboradoresDto") ColaboradoresDto alterar, @PathVariable Long id, HttpServletRequest request) {

        // 1. Validar sessão
        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }
        boolean retorno = colaboradoresService.atualizarColaborador(id, alterar);

        if (retorno) {
            return "redirect:/listacolaborador";
        }
        return "redirect:/listacolaborador/" + id.toString() + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        System.out.println("id =" + id);

        boolean retorno = colaboradoresService.remover(id);

        if (retorno) {
            return ResponseEntity.ok().body("Colaborador excluido com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("erro ao excluir");
        }
    }
}
