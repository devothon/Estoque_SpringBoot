package Estoque_CRUD.controller;

import Estoque_CRUD.model.ProdutoModel;
import Estoque_CRUD.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/listar")
public class GetIdProduto {

    @Autowired
    private ProdutoRepository produto;

    @GetMapping(" /{id}")
    @ApiResponse(responseCode = "200",description = "Retorna o produto")
    @ApiResponse(responseCode = "404", description = "quando não econtrado o ID")
    public ResponseEntity<Object> listarID(@PathVariable Long id)
    {
        Optional<ProdutoModel> produto=this.produto.findById(id);
        if(produto.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }
}
