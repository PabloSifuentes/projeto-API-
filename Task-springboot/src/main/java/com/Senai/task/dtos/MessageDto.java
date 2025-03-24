
package com.Senai.task.dtos;

public class MessageDto {

    private boolean sucesso;
    private String message;

    public MessageDto() {}

    public MessageDto(boolean sucesso, String message) {
        this.sucesso = sucesso;
        this.message = message;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
