package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

;

public class UsuarioAutenticado extends Usuario {

	private String nome;
	private String sobreNome;
	private String email;
	private String senha;
	private String cpf;
	private String cep;
	private String telefone;
	List<Produto> listProdutos = new ArrayList<>();

	public UsuarioAutenticado() {

	}

	public UsuarioAutenticado(String nome, String sobreNome, String email, String senha, String cpf, String cep,
			String telefone) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.cep = cep;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email + ", senha=" + senha + ", cpf="
				+ cpf + ", cep=" + cep + ", telefone=" + telefone + "]";
	}

	public List<Produto> getListProdutos() {
		return listProdutos;
	}

	public void addProduto(Produto produto) {
		listProdutos.add(produto);
	}

	public void addProdutoNaPosicao(int i, Produto produto) {
		listProdutos.add(i, produto);
	}

	public void removerProduto(int i) {
		listProdutos.remove(i);
	}

	public void cadastrarAnuncio(UsuarioAutenticado usuarioAutenticado, List<Produto> list) {

		Scanner scan = new Scanner(System.in);
		System.out.print("informe seu ununcio");
		String anuncio = scan.nextLine();
		double precoDiario = scan.nextDouble();
		int quantidadesDePessoas = scan.nextInt();
		scan.nextLine();
		Random gerador = new Random();

		Produto produto = new Produto(anuncio, precoDiario, quantidadesDePessoas, gerador.nextInt(1000000));
		usuarioAutenticado.addProduto(produto);
		list.add(produto);

	}

	public void listarAnunciosUsuario(UsuarioAutenticado usuarioAutenticado) {
		for (Produto a : usuarioAutenticado.getListProdutos()) {
			System.out.println(a);
		}
	}
	
	public void editarAnuncio(UsuarioAutenticado usuarioAutenticado) {
		Scanner scan = new Scanner(System.in);
		for (Produto listaDeProdutoDoUsuario : usuarioAutenticado.getListProdutos()) {
			System.out.println(listaDeProdutoDoUsuario);
		}
		System.out.println("digite o codigo do anuncio que quer atualizar: ");
		int codigo = scan.nextInt();
		scan.nextLine();
		for (Produto listaDeProdutoDoUsuario : usuarioAutenticado.getListProdutos()) {
			
			if (codigo == listaDeProdutoDoUsuario.getCodigo()) {
				System.out.print("informe seu ununcio");
				String anuncio = scan.nextLine();
				listaDeProdutoDoUsuario.setNome(anuncio);
				System.out.print("informe preco diario");
				double precoDiario = scan.nextDouble();
				listaDeProdutoDoUsuario.setPrecoDiario(precoDiario);
				System.out.print("quantidades de pessoas");
				int quantidadesDePessoas = scan.nextInt();
				listaDeProdutoDoUsuario.setHospedesQtd(quantidadesDePessoas);
				scan.nextLine();

				break;
			}
			

		}
	}
	
	public void excluirAnuncio(UsuarioAutenticado usuarioAutenticado, List<Produto> listProdutos) {
		Scanner scan = new Scanner(System.in);
		for (Produto a : usuarioAutenticado.getListProdutos()) {
			System.out.println(a);
		}
		System.out.println("Digite o codigo do anuncio que quer deletar: ");
		int codigo = scan.nextInt();
		int i = 0;
		int j = 0;
		for (Produto a : usuarioAutenticado.getListProdutos()) {

			if (codigo == a.getCodigo()) {
				usuarioAutenticado.removerProduto(i);
				for (Produto b : listProdutos) {

					if (codigo == b.getCodigo()) {
						listProdutos.remove(j);
						System.out.println("Item removido com sucesso");
						break;

					}
					j++;

				}
				break;

			}

			i++;

		}
	}
	
	


}
