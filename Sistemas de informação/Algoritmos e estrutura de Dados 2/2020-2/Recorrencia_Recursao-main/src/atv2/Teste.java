package atv2;

import java.io.FileNotFoundException;

import Arquivo.LeitorArquivo;

public class Teste {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String array[] = LeitorArquivo.getTextos("src/atv2/letras.txt");
		int k = 3;
		
		System.out.println("#### POSSIBILIDADES PARA k = " + k + " ####");
		Concat.list(array, k);
		
		//para mostrar todas
		System.out.println("\n#### TODAS POSSIBILIDADES ATE k = " + k + " ####");
		Concat.listAll(array, k);
		
	}

}
