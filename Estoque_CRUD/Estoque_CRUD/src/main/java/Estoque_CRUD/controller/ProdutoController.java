package Estoque_CRUD.controller;

import Estoque_CRUD.model.ProdutoModel;
import Estoque_CRUD.dto.ProdutoDTO;
import Estoque_CRUD.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produto;

    @ApiResponse(responseCode = "200",description = "Retorna o produto")
    @ApiResponse(responseCode = "404", description = "quando a lista esta vazia")
    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoModel>> listar(){
        List<ProdutoModel> produto=this.produto.findAll();
        if(produto.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @ApiResponse(responseCode = "200",description = "Retorna o produto")
    @ApiResponse(responseCode = "404", description = "quando não econtrado o ID")
    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> listarID(@PathVariable Long id){
        Optional<ProdutoModel>produto=this.produto.findById(id);
        if(produto.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @PostMapping("/criar")
    @ApiResponse(responseCode = "201",description = "Cria o produto")
    public  ResponseEntity<ProdutoModel> criar(@RequestBody @Valid ProdutoDTO produtoDTO){
        var Produto = new ProdutoModel();
        BeanUtils.copyProperties(produtoDTO,Produto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(Produto);
    }

    @PutMapping("/atualizar/{id}")
    @ApiResponse(responseCode = "200",description = "Atualiza o produto")
    @ApiResponse(responseCode = "404", description = "quando não econtrado o ID")
    public ResponseEntity<Object> atualizarId(@PathVariable Long id,@RequestBody ProdutoDTO Prod){

        Optional<ProdutoModel>produto=this.produto.findById(id);
        if(produto.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        BeanUtils.copyProperties(Prod,produto);
        var ProdAtualizado=produto.get();
        this.produto.save(ProdAtualizado);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto atualizado");

    }

    @DeleteMapping("/Deletar/{id}")
    @ApiResponse(responseCode = "200",description = "Deleta o produto")
    @ApiResponse(responseCode = "404", description = "quando não econtrado o ID")
    public ResponseEntity<Object> deletarID(@PathVariable Long id){

        Optional<ProdutoModel>produto=this.produto.findById(id);
        if(produto.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var ProduDeletar=produto.get();
        this.produto.delete(ProduDeletar);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado");
    }

    @ApiResponse(responseCode = "200",description = "Deleta todos os produtos")
    public ResponseEntity<Object> deletarTodos()
    {
        this.produto.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Produtos deletados");
    }
}