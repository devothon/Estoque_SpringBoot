package Estoque_CRUD.controller;

import Estoque_CRUD.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class DeleteAllProduto {

    @Autowired
    private ProdutoRepository produto;

    @DeleteMapping("/deletar")
    @ApiResponse(responseCode = "200",description = "Deleta todos os produtos")
    public ResponseEntity<Object> deletarTodos()
    {
        this.produto.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Produtos deletados");
    }
}
