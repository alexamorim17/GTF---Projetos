package Main;

import java.util.Scanner;

import Dados.Colega;
import Dados.Livro;
import Registro.RegistroColega;
import Registro.RegistroLivro;

public class Main {
	
	private static RegistroLivro rL;
	private static RegistroColega rC;
	static Scanner ler = new Scanner(System.in);
	

	
	public static void adicionarColega() {
		Scanner ler = new Scanner(System.in);
		Colega c;
		String nome;
		String telefone;
		
		System.out.println("Nome: ");
		nome = ler.nextLine();
		System.out.println("Telefone: ");
		telefone = ler.nextLine();
		
		c = new Colega(nome, telefone);
		
		rC.adicionarColega(c);
		
		
		
	}
	
	public static void adicionarLivro() {
		Scanner ler = new Scanner(System.in);
		String titulo,autor;
		Double valor;
		Livro l;
		System.out.println("==> Adicionar Livro:\n");
		System.out.print("Titulo: ");
		titulo = ler.nextLine();
		System.out.print("Autor: ");
		autor = ler.nextLine();
		System.out.print("Valor: ");
		valor = ler.nextDouble();
					
		l = new Livro(titulo, autor, valor);
		rL.adicionarLivro(l);
	

	}

	
	private static void listarTodosLivros() {
		System.out.println("=== Lista de livros disponiveis ===");
		System.out.println("Cod\t Titulo\t\t\t Autor\t\t Valor\t\t Situacao\t\t Colega" );
		for (int i = 0; i < rL.size(); i++) {
			Livro l = rL.getLivro(i);
			if(l.getDataEmprestimo()==null){
			System.out.printf ("%s\t %s\t\t  %s\t\t\t %s\t\t Livro Disponivel\n",
					l.getCodigoDoLivro(), l.getTitulo(), l.getAutor(), l.getValor());
			}
			else{
			System.out.printf ("%s\t %s\t\t  %s\t\t\t %s\t\t %s\n",
						l.getCodigoDoLivro(), l.getTitulo(), l.getAutor(), l.getValor(), l.getColegaComLivro());
			}
		}
	}
	
	public static void listadeColegas() {
		System.out.println("==========Lista de Colegas==========");
		for(int x = 0; x <rC.size();x++) {
			System.out.println("Cod\t Nome\t\t\t Telefone" );
			Colega c = rC.getColega(x);
			System.out.printf ("%s\t %s\t\t  %s\n",
					c.getCodigoDoColega(), c.getNome(), c.getTelefone());
			}
		}
	

	private static void listarTodosColegas() {
		System.out.println("=== Lista de Colegas ===");
		System.out.println("Cod\t Nome\t\t\t Telefone" );
		for (int i = 0; i < rC.size(); i++) {
			Colega c = rC.getColega(i);
			System.out.printf ("%s\t %s\t\t  %s\n",
					c.getCodigoDoColega(), c.getNome(), c.getTelefone());
			}
	}
	
	
	
	
	private static void emprestarLivro() {
		boolean flag=false;
		boolean flagColega=false;
		int cod;
		int codColega;
		System.out.print("Digite o codigo do livro a ser emprestado: ");
		cod = ler.nextInt();
		ler.nextLine();
		Main.listadeColegas();
		System.out.println();
		System.out.print("Digite o codigo do colega a emprestar o livro: ");
		codColega = ler.nextInt();
		ler.nextLine();
		for (int i = 0; i < rC.size(); i++) {
			Colega colega = rC.getColega(i);
			if(colega.getCodigoDoColega()==codColega){
			flagColega=true;
			for (int i1 = 0; i1 < rL.size(); i1++) {
				Livro l = rL.getLivro(i1);
				if(l.getCodigoDoLivro()==cod&&l.getDataEmprestimo()==null){
				rL.emprestaLivro(l,colega);
				System.out.println("livro codigo "+l.getCodigoDoLivro()+" emprestado com sucesso para o colega: " + colega.getNome() + ".");
				System.out.println("Data de emprestimo: "+l.getDataEmprestimo());
				flag=true;
				}
			}
			if(flag==false){
				System.out.println("Livro não encontrado ou já emprestado.");
			}
			}
		}
		if(flagColega==false){
			System.out.println("Colega não encontrado.");
		}
		
		
	}
	
	private static void devolverLivro() {
		boolean encontrado = false;
		System.out.println("Digite o código do livro a ser devolvido: ");
		int cod = ler.nextInt();
		
		for(int x = 0;x<rL.size();x++) {
			Livro l = rL.getLivro(x);
			if(cod == l.getCodigoDoLivro()) {
				encontrado = true;
				l.setDataEmprestimo(null);
				System.out.println("Livro código "+l.getCodigoDoLivro()+" devolvido com sucesso !");
				
			}
		
		}
		if(encontrado == false) {
			System.out.println("Livro não encontrado.");
		}
	}
	
	private static void ListarLivrosAZ() {
		rL.livroAZ();
	}
	public static void main(String[] args) {

		rL = new RegistroLivro();
		rC = new RegistroColega();
		
		Livro l1 = new Livro ("Programacao Java I", "Jose da Silva", 98.50);
		Livro l2 = new Livro ("Calculo II", "Marina Golvea", 150.00);
		Livro l3 = new Livro ("Eletricidade Aplicada II", "Alexandre Timbu", 60.80);
		Livro l4 = new Livro ("Microeletronica II", "Luis Amaro", 52.99);
		Livro l5 = new Livro ("Arquitetura de Processadores", "Mateus Budista", 180.00);
		rL.adicionarLivro(l1);
		rL.adicionarLivro(l2);
		rL.adicionarLivro(l3);
		rL.adicionarLivro(l4);
		rL.adicionarLivro(l5);
		Colega c1 = new Colega ("Amarildo Silva", "41996635285");
		Colega c2 = new Colega ("Jose dos Santos", "4198574525");
		Colega c3 = new Colega ("Isabela Amaral", "41986325412");
		Colega c4 = new Colega ("Bruna de Oliveira", "41997456328");
		rC.adicionarColega(c1);
		rC.adicionarColega(c2);
		rC.adicionarColega(c3);
		rC.adicionarColega(c4);
		
		
		
		int op;
		do {
			System.out.println("\n==> Menu:\n");
			System.out.println("   0 - sair");
			System.out.println("   1 - adiciona livro");
			System.out.println("   2 - adiciona colega");
			System.out.println("   3 - emprestar livro");
			System.out.println("   4 - devolver livro");
			System.out.println("   5 - listar livros por ordem alfabetica");
			System.out.print("\n   Opcao: ");
			op = ler.nextInt();
			ler.nextLine(); // consumir o enter

			switch (op) {
			case 0: 
				System.out.println("Saindo..."); // System.exit(0);
				break;
			case 1:
				adicionarLivro();
				break;
			case 2:
				adicionarColega();
				break;
			case 3:
				listadeColegas();
				emprestarLivro();
				break;
			case 4:
				devolverLivro();
				break;
			case 5:
				ListarLivrosAZ();
				listarTodosLivros();
				break;	
			default:
				System.out.println("Opcao invalida!\n\n");
				break;
			}
		} while (op != 0);

	}
	
	
}
	
	
	

