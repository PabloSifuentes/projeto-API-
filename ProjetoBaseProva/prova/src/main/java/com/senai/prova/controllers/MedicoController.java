package com.senai.prova.controllers;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.services.MedicoService;
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
    public String cadastraMedico(@ModelAttribute("medicoDto") MedicoDto medicoDto) {

        boolean retorno = medicoService.adicionarMedico(medicoDto);

        if (retorno) {
            return "redirect:/listamedico";
        }
        return "redirect:/cadastramedico?erro";
    }

    @PostMapping("/{id}")
    public String atualizaMedico(@ModelAttribute("medicoDto") MedicoDto medicoDto, @PathVariable Long id) {

        //--Chamar o service para atualizar
        boolean retorno = false;

        retorno = medicoService.atualizarMedico(id, medicoDto);

        if (retorno) {
            return "redirect:/listamedico";
        }

        return "redirect:/alteramedico/" + id.toString() + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        boolean retorno = medicoService.removerMedico(id);

        if (retorno) {
            return ResponseEntity.ok().body("deu certo");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("não deu certo");
        }
    }
}
