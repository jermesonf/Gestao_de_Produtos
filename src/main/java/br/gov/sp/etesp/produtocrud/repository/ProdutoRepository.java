package br.gov.sp.etesp.produtocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.etesp.produtocrud.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
