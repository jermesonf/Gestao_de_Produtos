package br.gov.sp.etesp.produtocrud.service;

import br.gov.sp.etesp.produtocrud.dto.Usuario;

public interface UsuarioService {
	
	public void cadastrar(Usuario usuario);
	
	public boolean autenticar(Usuario usuario);

}
