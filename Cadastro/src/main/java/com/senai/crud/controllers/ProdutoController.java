package com.senai.crud.controllers;

import com.senai.crud.dtos.MensagemDto;
import com.senai.crud.dtos.ProdutoAtualizarDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public String cadastrarNovoProduto(@ModelAttribute("cadastroDto")ProdutoDto cadastrarProduto){

        boolean mensagemDto = produtoService.adicionarProduto(cadastrarProduto);

        if (mensagemDto == true){
            return "redirect:/cadastro?sucesso";
        }
        return "redirect:/cadastro?erro";

    }

    @PostMapping("/{id}")
    public String atualizarProduto(@ModelAttribute("produtoAtualizarDto") ProdutoAtualizarDto produtoDto, @PathVariable Long id){

        boolean retorno = produtoService.atualizarProduto(id, produtoDto);

        System.out.println("chegou no controller=" + retorno);

        if (retorno){
            return "redirect:/produtolista";
        }
        System.out.println("vai para atualizar");

        return "redirect:/produtoatualizar/" + id.toString() + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDto> deletarProduto(@PathVariable Long id){

        MensagemDto mensagem = produtoService.deletTask(id);

        if (mensagem.isSucesso()){
            return ResponseEntity.ok().body(mensagem);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
}
