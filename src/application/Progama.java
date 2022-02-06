package application;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.Usuario;
import entities.UsuarioAutenticado;

public class Progama {

	public static void main(String[] args) {
		UsuarioAutenticado usuario = new UsuarioAutenticado("pepe", "daltro", "1", "2", "1234", "1234", "1224");
		UsuarioAutenticado usuario2 = new UsuarioAutenticado("cece", "daltro", "1", "3", "1234", "1234", "1224");
		UsuarioAutenticado usuario3 = new UsuarioAutenticado("lipe", "daltro", "1", "4", "1234", "1234", "1224");
		Scanner scan = new Scanner(System.in);
		Produto produto1 = new Produto("casa bahia", 1, 1, 1);
		Produto produto2 = new Produto("apart sp", 1, 1, 2);
		Produto produto3 = new Produto("minas gerais", 1, 1, 3);
		Produto produto4 = new Produto("Rio dde janeiro", 1, 1, 4);
		Produto produto5 = new Produto("Orlando", 1, 1, 5);
		Produto produto6 = new Produto("São luiz", 1, 1, 6);
		Produto produto7 = new Produto("Ceara", 1, 1, 7);
	
		usuario.addProduto(produto1);
		usuario.addProduto(produto2);
		usuario.addProduto(produto3);
		usuario.addProduto(produto4);
		usuario.addProduto(produto5);
		usuario.addProduto(produto6);
		usuario.addProduto(produto7);
		

		List<Produto> listProdutos = new ArrayList<>();
		List<UsuarioAutenticado> listUsuarios = new ArrayList<>();
		
		listUsuarios.add(usuario);
		listUsuarios.add(usuario2);
		listUsuarios.add(usuario3);
		

		listProdutos.add(produto1);
		listProdutos.add(produto2);
		listProdutos.add(produto3);
		listProdutos.add(produto4);
		listProdutos.add(produto5);
		listProdutos.add(produto6);
		listProdutos.add(produto7);

		int status = 0;
		
		
		UsuarioAutenticado usuarioAutenticado = new UsuarioAutenticado();
		

		while (status != 4) {
			System.out.println("-------------MENU--------------");
			System.out.println(
					"1--listar todos os anuncios\n 2--detahles de um anuncio\n 3--criar uma conta \n 4-- logar na conta"
							+ "\n 5--cadastrar anuncio\n 7--lista seus anuncios\n 8--editar anuncio\n 9--excluir anuncio");

			int op = scan.nextInt();
			scan.nextLine();
			switch (op) {

			case 1:
				usuario.listarAnuncios(listProdutos);
				break;

			case 2:
				usuario.detalhesAnuncio(listProdutos);

				break;
			case 3:
				usuario.criarConta(listUsuarios);
				break;

			case 4:
				usuarioAutenticado = usuario.fazerLogin(listUsuarios, usuarioAutenticado);

				break;
			case 5:
				if(usuarioAutenticado.getEmail()!=null) {
				usuarioAutenticado.cadastrarAnuncio(usuarioAutenticado, listProdutos);
				}else {
					System.out.println("não autenticado");
				}
				break;

			case 6:
				status = 4;
			case 7:
				if(usuarioAutenticado.getEmail()!=null) {
				usuarioAutenticado.listarAnunciosUsuario(usuarioAutenticado);
				}
				
				break;

			case 8:
				if (usuarioAutenticado.getEmail()!=null) {
					usuarioAutenticado.editarAnuncio(usuarioAutenticado);
					} else {
					System.out.println("Usuario não autenticado");
				}
				break;

			case 9:
				if (usuarioAutenticado.getEmail()!=null) {
				usuarioAutenticado.excluirAnuncio(usuarioAutenticado,listProdutos);
				}else {
					System.out.println("Usuario não autenticado. ");
				}
			}

		}

	}
}
