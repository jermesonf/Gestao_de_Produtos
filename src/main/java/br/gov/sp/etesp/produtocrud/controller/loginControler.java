package br.gov.sp.etesp.produtocrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.gov.sp.etesp.produtocrud.dto.Usuario;
import br.gov.sp.etesp.produtocrud.service.UsuarioService;

@Controller
public class loginControler {
	
		@Autowired
		UsuarioService service;
	
		@GetMapping("/")
		public String login(Model model) {
			return "login";
		}

		@GetMapping("/cadastrar")
		public String cadastro(Model model) {
			return "form-cadastro";
		}
		
		@PostMapping("/cadastro-salvar")
		public String cadastroUsuario(Usuario usuario) {
			//System.out.println(usuario.toString());
			service.cadastrar(usuario);
			return "redirect:/";
		}
		
		@PostMapping("/autenticar")
		public String autenticar(String email, String senha){

			// usamos var para que o java definina automaticamente o tipo da variavel exemplo: var x = "cafe" logo var se torna String
			var usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setPassword(senha);

			var isAutenticado = service.autenticar(usuario);

			if(isAutenticado){
				return "redirect:/home";

			}
			return "redirect:/";


		}
	}
