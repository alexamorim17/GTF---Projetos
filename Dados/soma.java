package Dados;

public class soma {
	public static void main(String[] args) {
	
		int v[] = new int [10];
		
		int i,j;
		boolean temvaloresRepetidos;
		
		v[0] = 1;
		v[1] = 2;
		v[2] = 3;
		v[3] = 4;
		v[4] = 5;
		v[5] = 6;
		v[6] = 8;
		v[7] = 8;
		v[8] = 9;
		v[9] = 10;
		
		temvaloresRepetidos = false;
		
		for(i = 0; i <=9; i++) {
			for(j =9; j >= 0; j--) {
				if(i!=j) {
				System.out.print(v[i]+"\t");
				System.out.println(v[j]);}
				if (v[i] == v[j] && i!= j) {
					temvaloresRepetidos = true;
					}
	
			}
		
		}
		
		System.out.println(temvaloresRepetidos);
	}

}
