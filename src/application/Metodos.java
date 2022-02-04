package application;

import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.Usuario;
import entities.UsuarioAutenticado;

public class Metodos {
	Scanner scan = new Scanner(System.in);

	public void listarAnuncios(List<Produto> list) {
		System.out.println("anuncios");
		for (Produto a : list) {
			System.out.println(a.toString());
		}

	}

	public void detalhesAnuncio(List<Produto> list) {
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

	public void criarConta(List<Usuario> listUsuarios) {
		System.out.println(
				"criar uma conta como usuário comum: nome, sobrenome, CPF, email, telefone, CEP e senha. (P1)\r\n"
						+ "");
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

}
