package com.senai.prova.controllers;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.services.MedicoService;
import com.senai.prova.session.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medico")
public class MedicoController {
    
    @Autowired
    MedicoService medicoService;

    @PostMapping()
    public String cadastraMedico(@ModelAttribute("medicoDto")MedicoDto medicoDto, HttpServletRequest request) {


        if (ControleSessao.obter(request) == null) {
        return "redirect:/login";
        }

        boolean retorno = medicoService.adicionar(medicoDto);
            return retorno?"redirect:/listamedico" : "redirect:/cadastramedico?erro";
    }

    @PostMapping("/{id}")
    public String atualizaMedico(@ModelAttribute("medicoDto") MedicoDto alterar, @PathVariable Long id, HttpServletRequest request) {

        // 1. Validar sessão
        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }
            boolean retorno = medicoService.atualizar(id, alterar);

            if (retorno) {
                return "redirect:/listamedico";
            }
                return "redirect:/listamedico/" + id.toString() + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        System.out.println("id =" + id);

        boolean retorno = medicoService.excluir(id);

        if (retorno) {
            return ResponseEntity.ok().body("Médico excluido com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("erro ao excluir");
        }
}
}

