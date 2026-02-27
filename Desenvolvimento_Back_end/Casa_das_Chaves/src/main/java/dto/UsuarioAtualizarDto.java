package dto;

import model.UsuarioModel;

public class UsuarioAtualizarDto {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    public UsuarioAtualizarDto(){
    }

    public UsuarioAtualizarDto(Long id){
        this.id = id;
    }

    public UsuarioAtualizarDto(UsuarioModel usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }
    
}
