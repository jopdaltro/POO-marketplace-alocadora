package entities;

public class Produto {

	private String nome;
	private double precoDiario;
	private int quantidades;
	private double codigo;

	public Produto(String nome, double precoDiario, int quantidades,double codigo) {

		this.nome = nome;
		this.precoDiario = precoDiario;
		this.quantidades = quantidades;
		this.codigo = codigo;
	}

	public double getCodigo() {
		return codigo;
	}

	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoDiario() {
		return precoDiario;
	}

	public void setPrecoDiario(double precoDiario) {
		this.precoDiario = precoDiario;
	}

	public int getHospedesQtd() {
		return quantidades;
	}

	public void setHospedesQtd(int quantidades) {
		this.quantidades = quantidades;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", precoDiario=" + precoDiario + ", quantidades=" + quantidades + ", codigo="
				+ codigo + "]";
	}

	
	


	
}
