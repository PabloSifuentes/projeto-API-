package com.senai.prova.controllers;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.services.MedicoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastramedico")
public class CadastraMedicoController {
   
    @Autowired
    MedicoService medicoService;
    
    @GetMapping("")
    public String exibeAlteraMedico(Model model, HttpServletRequest request){
        
        MedicoDto medicoDto = new MedicoDto();
        model.addAttribute("medicoDto", medicoDto);
        
        return "cadastramedico";
    }
    
}
