package Registro;

import java.util.ArrayList;
import Dados.*;

public class RegistroColega{
	
	private ArrayList <Colega> rC;
	public RegistroColega() {
		rC = new ArrayList <Colega>();	
	}
	public Colega getColega (int indice) {
		return rC.get(indice);
	}
	public void adicionarColega(Colega c) {
		rC.add(c);
	}
	public void removerColega(Colega c) {
		rC.remove(c);
	}
	public void removerColega(int i) {
		rC.remove(i);
	}
	public int size() {
		return rC.size();
	}


}
