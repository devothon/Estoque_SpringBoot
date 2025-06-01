package Estoque_CRUD.controller;

import Estoque_CRUD.dto.ProdutoDTO;
import Estoque_CRUD.model.ProdutoModel;
import Estoque_CRUD.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class PostProduto {

    @Autowired
    private ProdutoRepository produto;

    @PostMapping("/criar")
    @ApiResponse(responseCode = "201",description = "Cria o produto")
    @ApiResponse(responseCode = "400",description = "Quando algum dos campo e nulo")
    public ResponseEntity<Object> criar(@RequestBody @Valid ProdutoDTO produtoDTO)
    {
        var Produto = new ProdutoModel();
        BeanUtils.copyProperties(produtoDTO,Produto);
        this.produto.save(Produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado");
    }
}
