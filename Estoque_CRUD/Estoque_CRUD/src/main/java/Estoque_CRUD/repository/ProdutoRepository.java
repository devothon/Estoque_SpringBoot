package Estoque_CRUD.repository;

import Estoque_CRUD.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositório do projeto
@Repository
public interface ProdutoRepository extends JpaRepository <Produto,Long>{

}
