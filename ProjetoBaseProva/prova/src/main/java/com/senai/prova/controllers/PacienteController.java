package com.senai.prova.controllers;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.dtos.PacienteDto;
import com.senai.prova.services.MedicoService;
import com.senai.prova.services.PacienteService;
import com.senai.prova.session.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping()
    public String cadastraPaciente(@ModelAttribute("pacienteDto") PacienteDto pacienteDto, HttpServletRequest request) {


        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }

        boolean retorno = pacienteService.adicionar(pacienteDto);
        return retorno?"redirect:/listapaciente" : "redirect:/cadastrapaciente?erro";
    }

    @PostMapping("/{id}")
    public String atualizaPaciente(@ModelAttribute("pacienteDto") PacienteDto alterar, @PathVariable Long id, HttpServletRequest request) {

        // 1. Validar sessão
        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }
        boolean retorno = pacienteService.atualizar(id, alterar);

        if (retorno) {
            return "redirect:/listapaciente";
        }
        return "redirect:/listapaciente/" + id.toString() + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        System.out.println("id =" + id);

        boolean retorno = pacienteService.excluir(id);

        if (retorno) {
            return ResponseEntity.ok().body("Paciente excluido com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("erro ao excluir");
        }
    }
}
