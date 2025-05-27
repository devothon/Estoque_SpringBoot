package Estoque_CRUD.repository;

import Estoque_CRUD.model.produtomodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface produtorepository extends JpaRepository <produtomodel,Long>{

}
