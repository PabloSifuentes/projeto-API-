package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.PerfilRiscoDto;
import com.senai.Gerenciamento_EPI_SA.service.EquipamentoService;
import com.senai.Gerenciamento_EPI_SA.service.PerfilRiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/perfil-risco")
public class PerfilRiscoController {

    @Autowired
    private PerfilRiscoService perfilRiscoService;

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping("/cadastros")
    public String mostrarFormulario(Model model) {
        model.addAttribute("perfil", new PerfilRiscoDto());
        model.addAttribute("todosEpis", equipamentoService.obterEquipamentos());
        model.addAttribute("riscosDisponiveis", Arrays.asList(
                "Químico", "Físico", "Biológico", "Queda",
                "Elétrico", "Ruído", "Térmico", "Mecânico"));
        return "cadastro-perfil";
    }

    @PostMapping
    public String salvarPerfil(@ModelAttribute PerfilRiscoDto perfilDto,
                               RedirectAttributes redirectAttributes) {
        perfilRiscoService.salvarPerfil(perfilDto);
        redirectAttributes.addFlashAttribute("sucesso", "Perfil cadastrado com sucesso!");
        return "redirect:/home";
    }

    @GetMapping("/perfil-risco/excluir/{id}")
    public String mostrarConfirmacaoExclusao(@PathVariable Long id, Model model) {
        // Pode adicionar lógica adicional se necessário
        return "redirect:/home"; // Redireciona de volta para a lista
    }

    @PostMapping("/excluir/{id}")
    public String excluirPerfil(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            perfilRiscoService.excluir(id);
            redirectAttributes.addFlashAttribute("sucesso", "Perfil excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao excluir perfil: " + e.getMessage());
        }
        return "redirect:/home";
    }
}
