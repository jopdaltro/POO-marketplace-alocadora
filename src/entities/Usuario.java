package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Usuario {

	public Usuario() {

	}

	public void listarAnuncios(List<Produto> list) {
		System.out.println("anuncios");
		for (Produto a : list) {
			System.out.println(a.toString());
		}

	}

	public void detalhesAnuncio(List<Produto> list) {
		Scanner scan = new Scanner(System.in);
		System.out.println("voce quer detalhes de qual anuncio? digite o codigo do anuncio");
		for (Produto a : list) {
			System.out.println(a.getNome());
		}
		double codigo = scan.nextDouble();
		for (Produto a : list) {

			if (codigo == a.getCodigo()) {
				System.out.println(a.toString());

			}
		}

	}

	public boolean logado() {

		return true;

	}

	public void criarConta(List<UsuarioAutenticado> listUsuarios) {
		System.out.println(
				"criar uma conta como usuário comum: nome, sobrenome, CPF, email, telefone, CEP e senha. (P1)\r\n"
						+ "");
		UsuarioAutenticado usuario = new UsuarioAutenticado();
		Scanner scan = new Scanner(System.in);
		System.out.println("nome:");
		usuario.setNome(scan.nextLine());
		System.out.println("email:");
		usuario.setEmail(scan.nextLine());
		System.out.println("senha:");
		usuario.setSenha(scan.nextLine());
		

		listUsuarios.add(usuario);
		System.out.println("usuario cadastrado");
		System.out.println(usuario.toString());
	}

	public UsuarioAutenticado fazerLogin(List<UsuarioAutenticado> listUsuarios, UsuarioAutenticado usuario) {
		Scanner scan = new Scanner(System.in);
		System.out.println("logar");
		System.out.println("email");
		String login = scan.nextLine();
		System.out.println("senha");
		String senha = scan.nextLine();

		for (UsuarioAutenticado usuarioDaLista : listUsuarios) {
			if (login.equals(usuarioDaLista.getEmail()) && senha.equals(usuarioDaLista.getSenha())) {
				System.out.println("bem vindo " + usuarioDaLista.getNome());
				usuario = usuarioDaLista;
				

			}
		}
		return usuario;

	}

}
