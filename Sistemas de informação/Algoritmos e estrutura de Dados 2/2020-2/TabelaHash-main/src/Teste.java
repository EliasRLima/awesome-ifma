import java.io.FileNotFoundException;
import java.util.Hashtable;

import Atv1.TableHash;

public class Teste {
	
	public static void main(String[] args) throws FileNotFoundException {
		String T = "src/Arquivos/tb1.txt"; //1 ate 30
		String S = "src/Arquivos/tb2.txt"; //primos 2 até 30
		
		TableHash tb = new TableHash(T, S);
		
		//mostrando S
		tb.showS();
		
		//mostrand T
		tb.showT();
		
		//salvando tempo inicial
		long tempoInicial = System.currentTimeMillis();
		
		//verificando se S é subconjunto de T
		boolean verificacao = tb.verificarSubconjunto(tb.getT(), tb.getS()); //(conjunto,subconjunto)
		if(verificacao) {
			System.out.println("S é subconjunto de T");
		}else {
			System.out.println("S nao é subconjunto de T");
		}
		//tempo atual - inicial para saber o custo de tempo que o metodo usou
		System.out.println("\n\n\nA verificacao levou " + (System.currentTimeMillis() - tempoInicial) + "ms para finalizar");
	}
	
}
