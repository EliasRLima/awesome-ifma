package atv1;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) throws FileNotFoundException {

		//entrada de teste
		
		ArrayList<Ponto> plano = LeitorArquivo.getArray("src/atv1/pontos.txt");
		
		Plano pc = new Plano(plano);
		pc.listMenorDistancia();
		
		pc.listTodasDistancias();
	}

}
