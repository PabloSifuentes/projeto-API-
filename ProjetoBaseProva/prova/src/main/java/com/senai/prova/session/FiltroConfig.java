package com.senai.prova.session;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltroConfig {

    @Bean
    public FilterRegistrationBean<FiltroAutenticacao> filtroAutenticacao() {
        FilterRegistrationBean<FiltroAutenticacao> registration = new FilterRegistrationBean<>();
        registration.setFilter(new FiltroAutenticacao());
        registration.addUrlPatterns("/listamedico", "/cadastramedico", "/atualizamedico");
        registration.setOrder(1); // prioridade de execução, se houver outros filtros
        return registration;
    }
}