package com.senai.Cadastro.controller;

import com.senai.Cadastro.dto.ListaUsuarioDto;
import com.senai.Cadastro.dto.RequisicaoDto;

import com.senai.Cadastro.dto.MensagemDto;
import com.senai.Cadastro.dto.RespostaDto;
import com.senai.Cadastro.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<MensagemDto> atualizarUsuario(@RequestBody RequisicaoDto usuario, @PathVariable Long id ){
        MensagemDto menssagem = service.atualizarUsuario(usuario, id);
        return ResponseEntity.ok().body(menssagem);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Object> obterUsuario(@PathVariable Long id){
        RespostaDto resposta = service.obterUsuario(id);
        if (resposta.getId() == 0){
            MensagemDto mensagem = new MensagemDto();
            mensagem.setMensagem("usuario não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok().body(resposta);
        }

    }

    @GetMapping("/usuarios")
        public ResponseEntity<List<ListaUsuarioDto>> obterLista(){

        List<ListaUsuarioDto> listar = service.listarUsuarios();
        return ResponseEntity.ok().body(listar);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<MensagemDto> deletar(@PathVariable Long id){

        MensagemDto menssagem = service.removerUsuario(id);
        return ResponseEntity.ok().body(menssagem);
    }
}
