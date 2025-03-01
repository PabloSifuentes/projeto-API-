package com.senai.Cadastro.service;

import java.util.concurrent.atomic.AtomicInteger;

public class UtilityService {

    private static final AtomicInteger contador = new AtomicInteger(1);

    public static Integer gerarId(){
        return contador.getAndIncrement();
    }
}
