package br.gov.sp.etesp.produtocrud.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CriptyServiceImpl implements CriptyService{
	
	
	@Override
	public String criptografar(String valor) {
		
		try {
			
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, gerarChave());
			
			byte[] byteCriptografados = cipher.doFinal(valor.getBytes("UTF-8"));
			
			return Base64.getEncoder().encodeToString(byteCriptografados);
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			
		} catch (NoSuchPaddingException e) {
			
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String descriptografar(String valor) {

		Cipher cipher;

			try {
				
				cipher = Cipher.getInstance("AES");
				cipher.init(Cipher.DECRYPT_MODE, gerarChave());
				byte[] byteDescriptografados = cipher.doFinal(valor.getBytes("UTF-8"));
				var valorDescripty = Base64.getDecoder().decode(byteDescriptografados);
				return new String(valorDescripty);


			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null; 
	}
	
	
	
	//Criptografia
	private SecretKey gerarChave() {
		
		try {
			
			KeyGenerator chave = KeyGenerator.getInstance("AES");
			chave.init(256);
			return chave.generateKey();
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	

}
