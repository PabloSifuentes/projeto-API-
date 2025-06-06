package com.senai.prova.controllers;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.dtos.PacienteDto;
import com.senai.prova.dtos.UsuarioSessaoDto;
import com.senai.prova.services.MedicoService;
import com.senai.prova.services.PacienteService;
import com.senai.prova.session.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/listapaciente")
public class ListaPacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public String exibeAlteraPaciente(Model model, HttpServletRequest request){

        //--Fazer: Validar sessão
        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);
        if (usuarioSessao.getId() == 0L) {
            return "redirect:/login";
        }

        List<PacienteDto> pacientes = pacienteService.obterPaciente();
        model.addAttribute("pacientes", pacientes);
        return "listapaciente";
    }
}
