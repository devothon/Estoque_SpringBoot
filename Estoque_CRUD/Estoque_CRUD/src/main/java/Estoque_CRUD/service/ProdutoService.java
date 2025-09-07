package Estoque_CRUD.service;

import Estoque_CRUD.dto.ProdutoRequestDTO;
import Estoque_CRUD.model.Produto;
import Estoque_CRUD.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

}
