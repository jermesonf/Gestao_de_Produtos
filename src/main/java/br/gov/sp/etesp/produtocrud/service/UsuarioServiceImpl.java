package br.gov.sp.etesp.produtocrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etesp.produtocrud.dto.Usuario;
import br.gov.sp.etesp.produtocrud.entity.UsuarioEntity;
import br.gov.sp.etesp.produtocrud.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	CriptyService criptyService;

	@Override
	public void cadastrar(Usuario usuario) {
		var dadosUsuario = mapperEntity(usuario);
		repository.save(dadosUsuario);
		
	}

	@Override
	public boolean autenticar(Usuario usuario) {
		var user = repository.findByEmail(usuario.getEmail());
		//var passwordDes = criptyService.descriptografar(user.getSenha());
				
		if(user != null && usuario.getPassword().equals(usuario.getPassword()))
		{
			return true;
		}
		
		return false;
		
	}
	
	private UsuarioEntity mapperEntity(Usuario usuario) {
		//String senhaCripty = criptyService.criptografar(usuario.getPassword());
		var entity = new UsuarioEntity();
		entity.setNome(usuario.getNome());
		entity.setEmail(usuario.getEmail());
		entity.setCpf(usuario.getCpf());
		entity.setSenha(usuario.getPassword());
		entity.setId(usuario.getId());
		
		return entity;
	}

}
