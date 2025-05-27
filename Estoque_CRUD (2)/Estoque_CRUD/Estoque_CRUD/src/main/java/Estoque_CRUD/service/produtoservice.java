package Estoque_CRUD.service;

import Estoque_CRUD.model.produtomodel;
import Estoque_CRUD.repository.produtorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//Classe Service que cuida das requisições feitas
public class produtoservice {

    @Autowired
    private produtorepository Produto;

    public produtomodel adicionar (produtomodel produtos){
        return this.Produto.save(produtos);
    }

    public List<produtomodel>  listar(){
        return  this.Produto.findAll();
    }

    public produtomodel listar_ID(Long id){
        return  this.Produto.findById(id).orElse(null);
    }

    public produtomodel Atualizar(Long id, produtomodel produto){

        produtomodel produtosatualizar = this.listar_ID(id);
        produtosatualizar.setName(produto.getName());
        produtosatualizar.setPreco(produto.getPreco());
        return this.Produto.save(produtosatualizar);

    }

    public Boolean Delete (Long id){

        produtomodel flag = this.listar_ID(id);

        if(flag == null){
            return false;
        }
        this.Produto.deleteById(id);
        return true;
    }

}
