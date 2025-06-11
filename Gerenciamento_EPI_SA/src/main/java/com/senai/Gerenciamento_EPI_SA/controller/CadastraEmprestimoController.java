package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.ColaboradoresDto;
import com.senai.Gerenciamento_EPI_SA.dto.EmprestimoDto;
import com.senai.Gerenciamento_EPI_SA.dto.EquipamentoDto;
import com.senai.Gerenciamento_EPI_SA.dto.UsuarioSessaoDto;
import com.senai.Gerenciamento_EPI_SA.service.ColaboradoresService;
import com.senai.Gerenciamento_EPI_SA.service.EquipamentoService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cadastraemprestimo")
public class CadastraEmprestimoController {

    @Autowired
    EquipamentoService equipamentoService;

    @Autowired
    ColaboradoresService colaboradoresService;

    @GetMapping
    public String exibeAlteraEmprestimo(Model model, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);
        if (usuarioSessao.getId() == 0L) {
            return "redirect:/login";
        }

        EmprestimoDto emprestimoDto = new EmprestimoDto();
        List<ColaboradoresDto> listacolaborador = colaboradoresService.obterColaboradores();
        List<EquipamentoDto> listaequipamento = equipamentoService.obterEquipamentos();

        model.addAttribute("emprestimoDto", emprestimoDto);
        model.addAttribute("listacolaborador", listacolaborador);
        model.addAttribute("listaequipamento", listaequipamento);

        return "cadastraemprestimo";
    }
}
