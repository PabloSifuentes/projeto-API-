package com.senai.crud.services;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ListaCategoriasDto;
import com.senai.crud.dtos.MensagemDto;
import com.senai.crud.dtos.ProdutoAtualizarDto;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public boolean cadastrarCategoria (CategoriaDto categoria){

        CategoriaModel cadastro = new CategoriaModel();
        cadastro.setDescricao(categoria.getDescricao());
        repository.save(cadastro);
        return true;
    }

    public boolean atualizarCategoria (Long id, CategoriaDto atualizar){

        Optional<CategoriaModel> buscarID = repository.findByid(id);
        if (buscarID.isPresent()){

            CategoriaModel model = new CategoriaModel();
            model.setDescricao(atualizar.getDescricao());
            repository.save(model);
            return true;
        }
        return false;
    }

    public List<ListaCategoriasDto> listarCategorias (){

        //--Obter os usuários do banco de dados
        List<CategoriaModel> listaCategoria = repository.findAll();

        //--Criar a lista DTO para realizar o retorno
        List<ListaCategoriasDto> lista = new ArrayList<>();

        //--Percorre a lista de usuários do banco e converter em uma lista de DTO
        for ( CategoriaModel usuario :  listaCategoria ){

            //--Crio UM objeto DTO
            ListaCategoriasDto categoriaRetorno = new ListaCategoriasDto();

            //--Converto UM objeto model em UM objeto DTO
            categoriaRetorno.setId(usuario.getId());
            categoriaRetorno.setDescricao(usuario.getDescricao());

            //--Adciono o objeto DTO na lista de UsuarioDto
            lista.add(categoriaRetorno);
        }

        return lista;
    }

    public MensagemDto delet (Long id){

        Optional<CategoriaModel> buscarId = repository.findByid(id);
        if (buscarId.isPresent()){
            repository.delete(buscarId.get());
            return new MensagemDto(true, "Categoria excluido com sucesso!");
        }
        return  new MensagemDto(false, "ERRO na exclusão!");
    }

    public CategoriaDto obterCategoriaParaEdicao(Long id) {
        Optional<CategoriaModel> categoriaOP = repository.findById(id);
        if (!categoriaOP.isPresent()){
            //--quando não encontra retorna um objeto com id ZERO
            return new CategoriaDto(0L);
        }
        return CategoriaDto.of(categoriaOP.get());

    }

}
