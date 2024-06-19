package br.gov.sp.etesp.produtocrud.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProdutoDtoTest {

	//REALIZANDO TESTES
	
	@Test
	void testeProdutoDtoComSucess() {
		ProdutoDto dto = new ProdutoDto();
		dto.setId(1L);
		dto.setNomeProduto("Teste");
		dto.setQuantidade("2"); //bug deve ser inteiro
		dto.setTipo("A");
		dto.setValor(10.0);
		dto.setLote("lote");
		
		assertEquals(1L, dto.getId());
		assertEquals("Teste", dto.getNomeProduto());
		assertEquals("2", dto.getQuantidade());
		assertEquals("A", dto.getTipo());
		assertEquals(10.0, dto.getValor());
		assertEquals("lote", dto.getLote());
		
		Usuario usuario = new Usuario();
		usuario.setCpf("cpf");
		usuario.setEmail("email");
		usuario.setId(1L);
		usuario.setNome("nome");
		usuario.setPassword("senha");
		usuario.setPassword2("senha2");

		assertEquals(1L, usuario.getId());
		assertEquals("cpf", usuario.getCpf());
		assertEquals("email", usuario.getEmail());
		assertEquals("nome", usuario.getNome());
		assertEquals("senha", usuario.getPassword());
		assertEquals("senha2", usuario.getPassword2());
	}
	
}
