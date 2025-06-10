package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.EquipamentoDto;
import com.senai.Gerenciamento_EPI_SA.service.EquipamentoService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    EquipamentoService equipamentoService;

    @PostMapping()
    public String cadastraEquipamento(@ModelAttribute("equipamentoDto") EquipamentoDto equipamentoDto, HttpServletRequest request) {

        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }

        boolean retorno = equipamentoService.criarEquipamento(equipamentoDto);
        return retorno?"redirect:/listaequipamento" : "redirect:/cadastraequipamento?erro";
    }

    @PostMapping("/{id}")
    public String atualizaEquipamento(@ModelAttribute("equipamentoDto") EquipamentoDto alterar, @PathVariable Long id, HttpServletRequest request) {

        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }

        boolean retorno = equipamentoService.atualizarEquipamento(id, alterar);
        return retorno ? "redirect:/listaequipamento" : "redirect:/alteraequipamento/" + id + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        boolean retorno = equipamentoService.remover(id);
        return retorno
                ? ResponseEntity.ok("Equipamento excluído com sucesso")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao excluir");
    }
}