package controller;

import dto.UsuarioDto;
import dto.UsuarioSessaoDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import sessao.ControleSessao;

@Controller
public class UsuarioCadastroController {

    public String viewCadastroUsuario(Model model, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if(usuarioSessao.getId() == 0){
            return "redirect:/login";
        }
        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuarioDto", usuarioDto);

        return "usuariocadastro";
    }
}
