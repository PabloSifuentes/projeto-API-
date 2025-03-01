package com.senai.Cadastro.dto;

public class MensagemDto {

    private boolean sucesso;
    private String mensagem;

    public MensagemDto() {
        this.sucesso = true;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
