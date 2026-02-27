package service;

import dto.LoginDto;
import dto.MensagemDto;
import dto.RequestDto;
import dto.UsuarioSessaoDto;
import model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioSessaoDto toEnter(LoginDto login){

        UsuarioSessaoDto usuarioSessao = new UsuarioSessaoDto();

        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findAllByEmail(login.getEmail());

        if(usuarioOptional.isPresent()){
            if (usuarioOptional.get().getSenha().equals(login.getSenha())){
                usuarioSessao.setId(usuarioOptional.get().getId());
                usuarioSessao.setNome(usuarioOptional.get().getNome());
            }
        }
        return usuarioSessao;
    }

    public MensagemDto adicionarUsuario(RequestDto requestDto){

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(requestDto.getNome());
        usuarioModel.setEmail(requestDto.getEmail());
        usuarioModel.setSenha(requestDto.getSenha());

        usuarioRepository.save(usuarioModel);

        MensagemDto mensagem = new MensagemDto();
        mensagem.setMensagem("Cadastrado com sucesso!");
        return mensagem;
    }

    public boolean atualizarUsuario(Long id, Usu);

}
