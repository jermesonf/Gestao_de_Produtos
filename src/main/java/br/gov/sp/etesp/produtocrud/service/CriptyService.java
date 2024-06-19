package br.gov.sp.etesp.produtocrud.service;

public interface CriptyService {
	
	public String criptografar(String valor);
	public String descriptografar(String valor);

}
