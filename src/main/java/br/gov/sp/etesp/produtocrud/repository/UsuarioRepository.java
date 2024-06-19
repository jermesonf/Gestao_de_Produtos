package br.gov.sp.etesp.produtocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.etesp.produtocrud.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

	UsuarioEntity findByEmail(String email);
	
}
