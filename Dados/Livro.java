package Dados;

import java.time.LocalDateTime;

public class Livro implements Comparable<Livro>{

	private String titulo, autor;
	private LocalDateTime dataEmprestimo;
	private double valor;
	private static int codLv=1;
	private int codigoDoLivro;
	Colega colegaComLivro;
	
	public Livro(String titulo, String autor, double valor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.valor = valor;
		dataEmprestimo = null;
		colegaComLivro = null;
		this.codigoDoLivro = codLv;
		codLv++;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCodigoDoLivro() {
		return codigoDoLivro;
	}

	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getColegaComLivro() {
		return colegaComLivro.getNome();
	}

	public void setColegaComLivro(Colega colegaComLivro) {
		this.colegaComLivro = colegaComLivro;
	}
	
	public int compareTo(Livro l) {
		return this.titulo.compareToIgnoreCase(l.getTitulo());
	}
	

}