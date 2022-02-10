package Dados;

import java.util.Random;

public class ss {
	
	public static int func(int x,int y){
		if (y == 0)
			return x;
		else
			return func(y,x%y);
	}
	
		public static void main(String[] args) {
			
			int resultado;
			
			resultado = func(9,3);
			System.out.println(resultado);
		
			
		}

	}



