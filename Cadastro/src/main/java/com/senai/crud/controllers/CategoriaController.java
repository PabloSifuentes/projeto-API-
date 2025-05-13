package com.senai.crud.controllers;

import com.senai.crud.dtos.*;
import com.senai.crud.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @PostMapping
    public String cadastrarNovaCategoria(@ModelAttribute("categoriaDto") CategoriaDto cadastrarCategoria){

        boolean mensagemDto = service.cadastrarCategoria(cadastrarCategoria);

        if (mensagemDto == true){
            return "redirect:/cadastro?sucesso";
        }
        return "redirect:/cadastro?erro";
    }

    @PostMapping("/{id}")
    public String atualizarCategoria(@ModelAttribute("categoriaDto") CategoriaDto atualizarDto, @PathVariable Long id){

        boolean retorno = service.atualizarCategoria(id, atualizarDto);

        System.out.println("chegou no controller=" + retorno);

        if (retorno){
            return "redirect:/categorialista";
        }
        System.out.println("vai para atualizar");

        return "redirect:/categoriaatualizar/" + id.toString() + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDto> deletarCategoria(@PathVariable Long id){

        MensagemDto mensagem = service.delet(id);

        if (mensagem.isSucesso()){
            return ResponseEntity.ok().body(mensagem);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
}
