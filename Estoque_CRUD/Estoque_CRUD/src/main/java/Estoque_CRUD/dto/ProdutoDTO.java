package Estoque_CRUD.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Classe DTO para filtrar dados
public record ProdutoDTO(@NotBlank String nome, @NotNull double preco) {

}
