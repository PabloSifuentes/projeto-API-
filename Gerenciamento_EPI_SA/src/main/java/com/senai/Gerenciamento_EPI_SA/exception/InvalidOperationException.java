package com.senai.Gerenciamento_EPI_SA.exception;

public class InvalidOperationException extends RuntimeException {


    public InvalidOperationException(String message) {
        super(message);
    }

    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
