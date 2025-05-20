package com.senai.crud.controllers;

import com.senai.crud.ControleSessao;
import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ProdutoAtualizarDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.services.CategoriaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoriaatualizar")
public class CategoriaAtualizarController {

    @Autowired
    CategoriaService service;

    @GetMapping("/{id}")
    public String obterCategoria(Model model, @PathVariable Long id, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        CategoriaDto categoriaCadastroDto = service.obterCategoriaParaEdicao(id);

        if(categoriaCadastroDto.getId() == 0 || categoriaCadastroDto.getId() == null){
            return "redirect:/categorialista";
        }
        model.addAttribute("categoriaAtualizarDto", categoriaCadastroDto);
        return "categoriaatualizar";
    }

}
