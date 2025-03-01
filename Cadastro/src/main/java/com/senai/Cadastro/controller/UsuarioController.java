package com.senai.Cadastro.controller;

import com.senai.Cadastro.dto.ListaUsuarioDto;
import com.senai.Cadastro.dto.RequisicaoDto;

import com.senai.Cadastro.dto.MensagemDto;
import com.senai.Cadastro.dto.RespostaDto;
import com.senai.Cadastro.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class UsuarioController {

    @Autowired
    UsuarioServico service;

    @PostMapping("/usuario")
    public ResponseEntity<MensagemDto> cadastrar(@RequestBody RequisicaoDto usuario) {

        MensagemDto menssagem = service.adicionarUsuario(usuario);
        return ResponseEntity.ok().body(menssagem);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<MensagemDto> atualizarUsuario(@RequestBody RequisicaoDto usuario, @PathVariable Integer id ){
        MensagemDto menssagem = service.atualizarUsuario(usuario, id);
        return ResponseEntity.ok().body(menssagem);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<RespostaDto> obterUsuario(@PathVariable Integer id){
        Object resposta = service.obterUsuario(id);
        return ResponseEntity.ok().body((RespostaDto) resposta);
    }

    @GetMapping("/usuarios")
        public ResponseEntity<List<ListaUsuarioDto>> obterLista(){

        List<ListaUsuarioDto> listar = service.listarUsuarios();
        return ResponseEntity.ok().body(listar);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<MensagemDto> deletar(@PathVariable Integer id){

        MensagemDto menssagem = service.removerUsuario(id);
        return ResponseEntity.ok().body(menssagem);
    }
}
