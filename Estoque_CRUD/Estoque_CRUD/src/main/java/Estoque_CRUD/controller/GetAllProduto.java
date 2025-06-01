package Estoque_CRUD.controller;

import Estoque_CRUD.model.ProdutoModel;
import Estoque_CRUD.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class GetAllProduto {

    @Autowired
    private ProdutoRepository produto;

    @GetMapping("/listar")
    @ApiResponse(responseCode = "200",description = "Retorna o produto")
    @ApiResponse(responseCode = "404", description = "quando a lista esta vazia")
    public ResponseEntity<Object> listar()
    {
        List<ProdutoModel> produto=this.produto.findAll();
        if(produto.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista vazia");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

}
