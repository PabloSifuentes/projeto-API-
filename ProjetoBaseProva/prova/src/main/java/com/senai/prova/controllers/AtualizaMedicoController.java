package com.senai.prova.controllers;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.dtos.UsuarioSessaoDto;
import com.senai.prova.services.MedicoService;
import com.senai.prova.session.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alteramedico")
public class AtualizaMedicoController {
    
    @Autowired
    MedicoService medicoService;
    
    @GetMapping("/{id}")
    public String exibeAlteraMedico(Model model, HttpServletRequest request, @PathVariable Long id, @ModelAttribute("medicoDto") MedicoDto medicoDto){
        
        //--Fazer: Validar sessão
        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        //--Fazer: buscar do MedicoService os dados do médico no Dto pelo "id"

        Boolean retorno = medicoService.atualizarMedico(id,medicoDto);

        model.addAttribute("medicoDto", medicoDto);
        
        return "alteramedico";
    }
    
}
