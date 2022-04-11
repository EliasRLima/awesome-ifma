package teste;

import Sort.Merge;
import Sort.Shell;
import Sort.Tim;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Shell Sort!");
		int[] vetor = {1, 0, 8, -8, -9, -7, 5, 7, -3, -4, 6, -1, -2, 4, -5, 3, 9, 2, -6}; 
		detalharVetor(vetor);
		Shell.sort(vetor);
		detalharVetor(vetor);
		
		
	}
	
	public static void detalharVetor(int vetor[]) {
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println("");
	}

}
