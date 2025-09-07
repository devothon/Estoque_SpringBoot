package Estoque_CRUD.dto;


import Estoque_CRUD.model.Produto;

//Classe DTO para filtrar dados
public record ProdutoResponseDTO(
        Long id,
        String name,
        Double preco
)
{
    public static ProdutoResponseDTO fromProduto(Produto produto)
    {
        return new ProdutoResponseDTO(produto.getId(), produto.getName(), produto.getPreco());
    }
}
