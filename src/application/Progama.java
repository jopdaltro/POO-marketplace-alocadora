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
		Produto produto1 = new Produto("casa bahia", 1, 1, 1.0);
		Produto produto2 = new Produto("apart sp", 1, 1, 2.0);
		Produto produto3 = new Produto("minas gerais", 1, 1, 3.0);
		usuario.addProduto(produto1);

		Metodos metodos = new Metodos();
		List<Produto> list = new ArrayList<>();
		List<UsuarioAutenticado> listUsuarios = new ArrayList<>();
		UsuarioAutenticado usuarioLogado[] = new UsuarioAutenticado[1];
		listUsuarios.add(usuario);
		listUsuarios.add(usuario2);

		list.add(produto1);
		list.add(produto2);
		list.add(produto3);

		int status = 0;
		double codigo;
		usuario.deslogado();
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
				metodos.listarAnuncios(list);
				break;

			case 2:
				metodos.detalhesAnuncio(list);

				break;
			case 3:
				usuario.criarConta(listUsuarios);
				break;

			case 4:
				usuario.fazerLogin(listUsuarios, usuarioAutenticado);

				break;
			case 5:
				if (!usuario.logado()) {
					usuarioAutenticado.cadastrarAnuncio(usuarioAutenticado, list);
				}else {
					System.out.println("não autenticado");
				}
				break;

			case 6:
				if (status == 1) {

				}
			case 7:
				if (!usuario.logado()) {
					usuarioAutenticado.listarAnunciosUsuario(usuarioAutenticado);
				}
				break;

			case 8:
				if (status == 1) {
					for (Produto a : usuarioLogado[0].getListProdutos()) {
						System.out.println(a);
					}
					System.out.println("digite o codigo do anuncio que quer atualizar: ");
					codigo = scan.nextInt();
					scan.nextLine();
					for (Produto a : usuarioLogado[0].getListProdutos()) {
						int i = 0;
						if (codigo == a.getCodigo()) {
							System.out.print("informe seu ununcio");
							String anuncio = scan.nextLine();
							a.setNome(anuncio);
							System.out.print("informe preco diario");
							double precoDiario = scan.nextDouble();
							a.setPrecoDiario(precoDiario);
							System.out.print("quantidades de pessoas");
							int quantidadesDePessoas = scan.nextInt();
							a.setHospedesQtd(quantidadesDePessoas);
							scan.nextLine();

							break;
						}
						i++;

					}
				} else {
					System.out.println("Usuario não autenticado");
				}
				break;

			case 9:
				if (status == 1) {
					for (Produto a : usuarioLogado[0].getListProdutos()) {
						System.out.println(a);
					}
					System.out.println("Digite o codigo do anuncio que quer deletar: ");
					codigo = scan.nextInt();
					int i = 0;
					int j = 0;
					for (Produto a : usuarioLogado[0].getListProdutos()) {

						if (codigo == a.getCodigo()) {
							usuarioLogado[0].removerProduto(i);
							for (Produto b : list) {

								if (codigo == b.getCodigo()) {
									list.remove(j);
									System.out.println("Item removido com sucesso");
									break;

								}
								j++;

							}
							break;

						}

						i++;

					}

				} else {
					System.out.println("Usuario não autenticado. ");
				}
			}

		}

	}
}
