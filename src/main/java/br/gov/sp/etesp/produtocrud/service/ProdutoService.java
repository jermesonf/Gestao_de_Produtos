package br.gov.sp.etesp.produtocrud.service;

import java.util.List;

import br.gov.sp.etesp.produtocrud.dto.ProdutoDto;
import br.gov.sp.etesp.produtocrud.entity.Produto;

public interface ProdutoService {
	
	public Produto cadastrarProduto(ProdutoDto dto);
	
	public void excluirProduto(Long id);
	
	public Produto editarProduto(Produto produto);
	
	public List<Produto> listaDeProdutos();

	public Produto buscarProdutoPorId(Long id);
}
