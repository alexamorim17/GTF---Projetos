package Registro;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import Dados.Colega;
import Dados.Livro;

public class RegistroLivro {

	private ArrayList<Livro> rL;

	public RegistroLivro() {
		rL = new ArrayList <Livro>();
	}

	public Livro getLivro (int indice) {
		return rL.get(indice);
	}
	
	public void adicionarLivro(Livro livro) {
		rL.add(livro);
	}
	
	public void deletarLivro(Livro livro) {
		rL.remove(livro);
	}
	
	public void deletarLivro(int i) {
		rL.remove(i);
	}
	

	public void emprestaLivro (Livro livro, Colega colega){
		LocalDateTime now = LocalDateTime.now();
		livro.setDataEmprestimo(now);
		livro.setColegaComLivro(colega);
		
	}
	public int size() {
		return rL.size();
	}
	
	
	
	public void livroAZ() {
		Collections.sort(rL);
	}
}
