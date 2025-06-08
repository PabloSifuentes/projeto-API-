package com.senai.Gerenciamento_EPI_SA.controller;

import com.senai.Gerenciamento_EPI_SA.dto.ColaboradoresDto;
import com.senai.Gerenciamento_EPI_SA.service.ColaboradoresService;
import com.senai.Gerenciamento_EPI_SA.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    ColaboradoresService colaboradoresService;

    @PostMapping()
    public String cadastraColaborador(@ModelAttribute("colaboradoresDto") ColaboradoresDto colaboradoresDto, HttpServletRequest request) {


        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }

        boolean retorno = colaboradoresService.criarColaborador(colaboradoresDto);
        return retorno?"redirect:/listacolaborador" : "redirect:/cadastracolaborador?erro";
    }

    @PostMapping("/{id}")
    public String atualizaColaborador(@ModelAttribute("colaboradoresDto") ColaboradoresDto alterar, @PathVariable Long id, HttpServletRequest request) {

        // 1. Validar sessão
        if (ControleSessao.obter(request) == null) {
            return "redirect:/login";
        }
        boolean retorno = colaboradoresService.atualizarColaborador(id, alterar);

        if (retorno) {
            return "redirect:/listacolaborador";
        }
        return "redirect:/listacolaborador/" + id.toString() + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        System.out.println("id =" + id);

        boolean retorno = colaboradoresService.remover(id);

        if (retorno) {
            return ResponseEntity.ok().body("Colaborador excluido com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("erro ao excluir");
        }
    }
}
