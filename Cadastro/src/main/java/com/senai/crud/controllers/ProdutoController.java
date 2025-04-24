package com.senai.crud.controllers;

import com.senai.crud.dtos.MensagemDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public String cadastrarNovoProduto(@ModelAttribute("cadastroDto")ProdutoDto cadastrarProduto){

        MensagemDto mensagemDto = produtoService.adicionarProduto(cadastrarProduto);

        if (mensagemDto.isSucesso()){
            return "redirect:/cadastro?sucesso";
        }
        return "redirect:/cadastro?erro";
    }

    @DeleteMapping
    public ResponseEntity<MensagemDto> deletarProduto(@PathVariable Long id){

        MensagemDto mensagem = produtoService.deletTask(id);

        if (mensagem.isSucesso()){
            return ResponseEntity.ok().body(mensagem);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
}
