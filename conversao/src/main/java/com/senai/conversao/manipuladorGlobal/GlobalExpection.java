package com.senai.conversao.manipuladorGlobal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

//Interceptador Global de Erros, sem precisar repetir código nos controllers.
@RestControllerAdvice
public class GlobalExpection {

    //O método é chamado automaticamente.
    //Cria uma resposta HTTP com código 400 (Bad Request).
    //Retorna um JSON no formato
    @ExceptionHandler(SuporteTipoConversao.class)
    public ResponseEntity<Map<String, String>> conversaoInvalido(SuporteTipoConversao erro) {

        return ResponseEntity.badRequest().body(Map.of("erro", erro.getMessage()));
    }
}
