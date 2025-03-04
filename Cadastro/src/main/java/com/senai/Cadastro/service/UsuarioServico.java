package com.senai.Cadastro.service;

import com.senai.Cadastro.dto.*;
import com.senai.Cadastro.models.UsuarioModel;
import com.senai.Cadastro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServico {

    @Autowired
    private UserRepository userRepository;

    public List<UsuarioModel> listaCadastro = new ArrayList<>();

    public MensagemDto LoginUsuario(LoginUsuarioDto login){

        MensagemDto mensagem = new MensagemDto();

        for(UsuarioModel usuarioModel : listaCadastro){
            if (usuarioModel.getLogin().equals(login.getLogin()) && usuarioModel.getSenha().equals(login.getSenha())){
                mensagem.setMensagem("Autenticação bem sucedida " +
                        "Seja Bem vindo "+usuarioModel.getNome());
                mensagem.setSucesso(true);
                return mensagem;
            }
        }
        mensagem.setMensagem("Erro na autenticação.");
        mensagem.setSucesso(false);
        return mensagem;
    }
    public MensagemDto adicionarUsuario(RequisicaoDto usuario) {

        MensagemDto mensagem = new MensagemDto();


        for (UsuarioModel usuarioModel1 : listaCadastro) {
            if (usuarioModel1.getLogin().equals(usuario.getLogin())) {
                mensagem.setMensagem("Erro: Login já existente!");
                mensagem.setSucesso(false);
                return mensagem;
            }
        }
            UsuarioModel usuarioModel = new UsuarioModel();
            usuarioModel.setId(UtilityService.gerarId());
            usuarioModel.setNome(usuario.getNome());
            usuarioModel.setLogin(usuario.getLogin());
            usuarioModel.setSenha(usuario.getSenha());
            listaCadastro.add(usuarioModel);

            mensagem.setMensagem("Usuario cadastrado com sucesso!");
            mensagem.setSucesso(true);
            return mensagem;
    }
    public List<ListaUsuarioDto> listarUsuarios(){
        List<ListaUsuarioDto> lista = new ArrayList<>();
        for(UsuarioModel usuario : listaCadastro){
            ListaUsuarioDto retornarUsuario = new ListaUsuarioDto();
            retornarUsuario.setId(usuario.getId());
            retornarUsuario.setNome(usuario.getNome());
            retornarUsuario.setLogin(usuario.getLogin());
            lista.add(retornarUsuario);
        }
            return lista;
    }

    public RespostaDto obterUsuario(Long id){

        RespostaDto retornarUsuario = new RespostaDto();
        retornarUsuario.setId(0L);

        for(UsuarioModel usuarioModel : listaCadastro){
            if (usuarioModel.getId().equals(id)){
                retornarUsuario.setId(usuarioModel.getId());
                retornarUsuario.setNome(usuarioModel.getNome());
                retornarUsuario.setLogin(usuarioModel.getLogin());
                retornarUsuario.setSenha(usuarioModel.getSenha());
            }
        }
                return retornarUsuario;
    }

    public MensagemDto atualizarUsuario(RequisicaoDto dados, Long id){

        MensagemDto mensagem = new MensagemDto();
        mensagem.setMensagem("Erro ao atualizar!");
        mensagem.setSucesso(false);

        for (UsuarioModel usuario : listaCadastro){
            if (usuario.getId().equals(id)){
               if (!usuario.getLogin().equals(dados.getLogin())){
                   usuario.setNome(dados.getNome());
                   usuario.setLogin(dados.getLogin());
                   usuario.setSenha(dados.getSenha());
                   mensagem.setMensagem("Usuario atualizado com sucesso!");
                   mensagem.setSucesso(true);
               } else {
                   mensagem.setMensagem("Erro, Longin já existente");
                   mensagem.setSucesso(false);
               }
            }
        }
        return mensagem;
    }

    public MensagemDto removerUsuario(Long id) {

        MensagemDto mensagem = new MensagemDto();
        mensagem.setMensagem("Erro ao excluir, tente novamente!");
        mensagem.setSucesso(false);

        UsuarioModel excluirUsuario = new UsuarioModel();
        excluirUsuario.setId(0L);

        for (UsuarioModel usuario : listaCadastro) {
            if (usuario.getId().equals(id)) {
                excluirUsuario = usuario;
            }
            if (excluirUsuario.getId() != 0){
                listaCadastro.remove(excluirUsuario);
                mensagem.setMensagem("Usuario excluido com sucesso!");
                mensagem.setSucesso(true);
            }
        }
     return mensagem;
    }
}