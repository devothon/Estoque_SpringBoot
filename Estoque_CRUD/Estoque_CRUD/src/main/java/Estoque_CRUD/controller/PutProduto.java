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
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class PutProduto {

    @Autowired
    private ProdutoRepository produto;

    @PutMapping("/atualizar/{id}")
    @ApiResponse(responseCode = "200",description = "Atualiza o produto")
    @ApiResponse(responseCode = "404", description = "quando não econtrado o ID")
    public ResponseEntity<Object> atualizarId(@PathVariable Long id, @RequestBody @Valid ProdutoDTO Prod)
    {

        Optional<ProdutoModel> produto=this.produto.findById(id);
        if(produto.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var ProdAtualizado=produto.get();
        BeanUtils.copyProperties(Prod,ProdAtualizado);
        this.produto.save(ProdAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body("Produto atualizado ");
    }
}
