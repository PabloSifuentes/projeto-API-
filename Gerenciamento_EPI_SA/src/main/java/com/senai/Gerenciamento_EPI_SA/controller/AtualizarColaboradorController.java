package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.ColaboradoresDto;
import com.senai.Gerenciamento_EPI_SA.dto.UsuarioSessaoDto;
import com.senai.Gerenciamento_EPI_SA.service.ColaboradoresService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alteracolaborador")
public class AtualizarColaboradorController {

    @Autowired
    ColaboradoresService colaboradoresService;

    @GetMapping("/{id}")
    public String exibeAlteraColaborador(Model model, HttpServletRequest request, @PathVariable Long id){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);
        if (usuarioSessao.getId() == 0L) {
            return "redirect:/login";
        }

        ColaboradoresDto colaboradorDto = colaboradoresService.obterColaboradoresId(id);
        if (colaboradorDto == null) {
            return "redirect:/listacolaborador";
        }

        model.addAttribute("colaboradorDto", colaboradorDto);
        return "alteracolaborador";
    }
}
