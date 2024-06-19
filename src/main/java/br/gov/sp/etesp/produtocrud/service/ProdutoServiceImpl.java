package br.gov.sp.etesp.produtocrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etesp.produtocrud.dto.ProdutoDto;
import br.gov.sp.etesp.produtocrud.entity.Produto;
import br.gov.sp.etesp.produtocrud.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository repository;

	@Override
	public Produto cadastrarProduto(ProdutoDto dto) {	
		Produto produto = fromEntidade(dto);
		Produto retorno = repository.save(produto);
		return retorno;
	}

	@Override
	public void excluirProduto(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Produto editarProduto(Produto produto) {
		return repository.save(produto);
	}

	@Override
	public List<Produto> listaDeProdutos() {
		return repository.findAll();
	}

	private Produto fromEntidade(ProdutoDto dto) {
		Produto p = new Produto();
		p.setId(dto.getId());
		p.setNomeProduto(dto.getNomeProduto());
		p.setQuantidade(dto.getQuantidade());
		p.setTipo(dto.getTipo());
		p.setLote(dto.getLote());
		p.setValor(dto.getValor());
		return p;
	}

	@Override
	public Produto buscarProdutoPorId(Long id) {
		Produto produto = repository.findById(id).get();
		return produto;
	}


}
