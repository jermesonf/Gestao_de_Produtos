package br.gov.sp.etesp.produtocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.gov.sp.etesp.produtocrud.dto.ProdutoDto;
import br.gov.sp.etesp.produtocrud.entity.Produto;
// import br.gov.sp.etesp.produtocrud.repository.ProdutoRepository;
import br.gov.sp.etesp.produtocrud.service.ProdutoService;

@Controller
public class HomeController {
	
	@Autowired
	ProdutoService service;
	
	@GetMapping("/home")
	public String abrirHome(Model model) {	
		List<Produto> produtos = service.listaDeProdutos();
		model.addAttribute("produtos",produtos);
		return "home";		
	}
	
	@PostMapping("/cadastrar")
	public String cadastrarProduto(ProdutoDto dto, Model model) {	
		service.cadastrarProduto(dto);
		List<Produto> produtos  = service.listaDeProdutos();
		model.addAttribute("produtos", produtos);
		return "redirect:/home";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluirProduto(@PathVariable Long id) {
		service.excluirProduto(id);
		return "redirect:/home";
	}
	
	@GetMapping("/editar/{id}")
	public String editarProduto(@PathVariable Long id, Model model) {
		Produto produto = service.buscarProdutoPorId(id);
		model.addAttribute("produto", produto);
		return "produto-editar";
	}
	
	 


}
