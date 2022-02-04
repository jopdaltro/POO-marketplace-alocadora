package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Usuario {

	
	Usuario(){
		
	}
	
	public boolean logado() {
		
		return true;
		
	}
	public boolean deslogado() {
		return false;
	}
	
	public void criarConta(List<UsuarioAutenticado> listUsuarios) {
		System.out.println(
				"criar uma conta como usuário comum: nome, sobrenome, CPF, email, telefone, CEP e senha. (P1)\r\n"
						+ "");
		Scanner scan = new Scanner(System.in);
		System.out.println("nome:");
		String nome = scan.nextLine();
		System.out.println("sobrenome:");
		String sobrenome = scan.nextLine();
		System.out.println("cpf:");
		String cpf = scan.nextLine();
		System.out.println("email:");
		String email = scan.nextLine();
		System.out.println("telefone:");
		String telefone = scan.nextLine();
		System.out.println("cep:");
		String cep = scan.nextLine();
		System.out.println("senha:");
		String senha = scan.nextLine();

		UsuarioAutenticado usuario = new UsuarioAutenticado(nome, sobrenome, email, senha, cpf, cep, telefone);
		listUsuarios.add(usuario);
		System.out.println("usuario cadastrado");
		System.out.println(usuario.toString());
	}
	
	public void fazerLogin(List<UsuarioAutenticado> listUsuarios, Usuario usuario) {
		Scanner scan = new Scanner(System.in);
		System.out.println("logar");
		System.out.println("email");
		String login = scan.nextLine();
		System.out.println("senha");
		String senha = scan.nextLine();

		for (UsuarioAutenticado a : listUsuarios) {
			if (login.equals(a.getEmail()) && senha.equals(a.getSenha())) {
				System.out.println("bem vindo " + a.getNome());
				usuario = new UsuarioAutenticado();
				usuario = a;
				
				
				
			}
		}
	}
	

	

}
