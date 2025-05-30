package com.senai.prova.controllers;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.dtos.UsuarioSessaoDto;
import com.senai.prova.services.MedicoService;
import java.util.ArrayList;
import java.util.List;

import com.senai.prova.session.ControleSessao;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listamedico")
public class ListaMedicoController {
      
    @Autowired
    MedicoService medicoService;
        
    @GetMapping
    public String exibeAlteraMedico(Model model, HttpServletRequest request){
        
        //--Fazer: Validar sessão
        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);
        if (usuarioSessao == model.asMap()){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }


        List<MedicoDto> medicos = new ArrayList();

        MedicoDto medico = new MedicoDto();
        medico.setId(1L);
        medico.setNome("Joao");
        medico.setEspecialidade("Ortopedista");
        medicos.add(medico);

        MedicoDto medico2 = new MedicoDto();
        medico2.setId(2L);
        medico2.setNome("Joao");
        medico2.setEspecialidade("Ortopedista");
        medicos.add(medico2);

        //--Fazer: Buscar do MedicoService uma lista de Medicos na variável "ListaMedicoDto"

        List<MedicoDto> medicoDto = medicoService.obterMedico();
        model.addAttribute("medicos", medicos);
        
        return "listamedico";
    }
}

