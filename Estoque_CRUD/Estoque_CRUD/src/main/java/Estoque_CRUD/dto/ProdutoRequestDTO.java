package Estoque_CRUD.dto;

import Estoque_CRUD.model.Produto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    @NotNull(message = "Nome produto invalido") @NotBlank(message = "Nome produto invalido")
    private String name;

    @Min(value = 0,message = "Valor deve ser positivo ou maior que 0")
    private Double preco;

    public Produto toProduto()
    {
        Produto produto = new Produto();

        produto.setName(this.name);
        produto.setPreco(this.preco);

        return produto;
    }

    public Produto updateProduto(Produto produto)
    {
        produto.setName(this.getName());
        produto.setPreco(this.getPreco());

        return produto;
    }
}
