package Dados;

public class Colega{

	private String nome, telefone;
	private static int codCl=1;
	private int codigoDoColega;
	
	public Colega(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.codigoDoColega = codCl;
		codCl++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getCodigoDoColega() {
		return codigoDoColega;
	}	

}
