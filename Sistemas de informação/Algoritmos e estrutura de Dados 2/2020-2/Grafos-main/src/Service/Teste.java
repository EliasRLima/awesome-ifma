package Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import estruturas.Aresta;

public class Teste {
   
	public static void main(String[] args) throws FileNotFoundException {
		
		//usado um arquivo onde cada linha esta com a estrutura "GRAFO1;GRAFO2;DISTANCIA_ENTRE_ELES"
		ServiceGrafo g = new ServiceGrafo("src/arquivos/ligacoes.txt");
		
		System.out.println("Entrada dos dados: ");
		g.list();
		
		//primeira questao
		System.out.println("\nOrdem busca Largura: "); //vertices mais antigos primeiro
		g.listLargura();
		System.out.println("\nOrdem busca Profundidade: "); //vertices mais recentes primeiro
		g.listProfundidade();
		
		//quarta questao
		System.out.println("\nO grafo é bipartido?\nResposta: " + g.isBipartido());
		
		//menor distancia
		String a = "null", b  = "null";
		Scanner in = new Scanner(new FileReader("src/arquivos/cidade.txt"));
		while (in.hasNextLine()) {
			String aux = in.nextLine().toString();
			if(a.equals("null")) {
				a = aux;
				continue;
			}
			
			if(b.equals("null")) {
				b = aux;
				continue;
			}
		}
		System.out.println("\n");
		g.menorDistancia(a, b);
	} 
}
