package Estoque_CRUD.controller;

import Estoque_CRUD.model.produtomodel;
import Estoque_CRUD.service.produtoservice;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/produto")
public class produtocontroller {

    @Autowired
    produtoservice servico;

    @ApiResponse(responseCode = "200",description = "Retorna o produto")
    @GetMapping("/listar")
    public ResponseEntity<List<produtomodel>> listar(){
        List<produtomodel>produto=this.servico.listar();
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @ApiResponse(responseCode = "200",description = "Retorna o produto")
    @ApiResponse(responseCode = "500", description = "quando não econtrado o ID")
    @GetMapping("/listar/{id}")
    public ResponseEntity<produtomodel> listarID(@PathVariable Long id){
        produtomodel Produto = this.servico.listar_ID(id);
        return ResponseEntity.status(HttpStatus.OK).body(Produto);
    }

    @PostMapping("/criar")
    @ApiResponse(responseCode = "201",description = "Cria o produto")
    public  ResponseEntity<produtomodel> criar(@RequestBody produtomodel P){
        produtomodel Produto = this.servico.adicionar(P);
        return  ResponseEntity.status(HttpStatus.CREATED).body(Produto);
    }

    @PutMapping("/atualizar/{id}")
    @ApiResponse(responseCode = "200",description = "Atualiza o produto")
    @ApiResponse(responseCode = "500", description = "quando não econtrado o ID")
    public ResponseEntity<produtomodel> atualizarId(@PathVariable Long id,@RequestBody produtomodel Prod){

        produtomodel Produto = this.servico.Atualizar(id,Prod);
        return ResponseEntity.status(HttpStatus.OK).body(Produto);
    }

    @DeleteMapping("/Deletar/{id}")
    @ApiResponse(responseCode = "200",description = "Deleta o produto")
    @ApiResponse(responseCode = "500", description = "quando não econtrado o ID")
    public  ResponseEntity<Object> deletarID(@PathVariable Long id){
     Boolean Produto = this.servico.Delete(id);
     return  ResponseEntity.status(HttpStatus.OK).body("Produto deletado");
    }
}
