package Estoque_CRUD.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Classe DTO para filtrar dados
public record ProdutoDTO(
        @NotBlank(message = "nome não pode ser nulo") String name,
        @NotNull(message = "preço não pode ser nulo") double preco){

 }
