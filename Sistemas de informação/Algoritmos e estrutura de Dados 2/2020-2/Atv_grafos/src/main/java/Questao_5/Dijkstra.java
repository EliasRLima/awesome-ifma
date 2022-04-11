package Questao_5;

/**
 *
 * @author artur e Fernando
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.text.DecimalFormat;

public class Dijkstra {

	// Mantém um num. Index para os Nodes(cidades)
	private Map<String, Vertices> Nome_Vertice;
        //DecimalFormat df = new DecimalFormat("#,###.00");

	public Dijkstra(){
		Nome_Vertice = new HashMap<String, Vertices>();
	}

	public void adicionaVertice(Vertices v){
		if (Nome_Vertice.containsKey(v.nome))
			throw new IllegalArgumentException("Nome da Cidade já existente.");
		Nome_Vertice.put(v.nome, v);
	}

	public Collection<Vertices> Valor_Vertices() {
		return Nome_Vertice.values();
	}

	public Vertices InicializaVertice(String nome) {
		return Nome_Vertice.get(nome);
	}

	public void AdicionaAresta(String nomeU, String nomeV, Double custo) {
		if (!Nome_Vertice.containsKey(nomeU))
			throw new IllegalArgumentException(nomeU + " Não encontrada, crie nova Aresta.");
		if (!Nome_Vertice.containsKey(nomeV))
			throw new IllegalArgumentException(nomeV + " Não encontrada, crie novo Vértice.");
		Vertices VerticeFonte = Nome_Vertice.get(nomeU);
		Vertices verticefim = Nome_Vertice.get(nomeV);
		Arestas newEdge = new Arestas(VerticeFonte, verticefim, custo);
		//adiciona fonte adj vertice
		VerticeFonte.AdicionaAresta(newEdge);
	}

	public void ArestaBidirecional(String nomeU, String nomeV, double custo) { //Bidirecional
		AdicionaAresta(nomeU, nomeV, custo);
		AdicionaAresta(nomeV, nomeU, custo);
	}

	public double Distancia_Euclidiana(double ux, double uy, double vx, double vy) {
                //Fórmula de distância entre dois pontos
		double distancia = Math.sqrt( Math.pow((vx-ux), 2) + Math.pow((vy-uy), 2));
		return distancia; 
	}

	public void Soma_DistEuclidiana(){
		for(Map.Entry<String, Vertices> entry: Nome_Vertice.entrySet()){
			//Para cada elemento da lista pega aresta adj
			List<Arestas> listaAresta = entry.getValue().ArestaAdj;
			//Vertices adj
			for(int i = 0; i < listaAresta.size(); i++){
				//Pega aresta por Index do Vértice
				Arestas e = listaAresta.get(i);
				e.distancia = Distancia_Euclidiana(e.fonte.x, e.fonte.y, e.fim.x, e.fim.y);
			}
                } 
	}

	public void Exe_Dijkstra(String s){
                DecimalFormat df = new DecimalFormat("#,###.00");
		for(Vertices v: Nome_Vertice.values()){
			v.distancia = Double.POSITIVE_INFINITY;
		}
		//lista que guarda Vértices visitados
		List<Vertices> visitou = new LinkedList<Vertices>();
                //Fila prioritária
		List<Vertices> pendente = new LinkedList<Vertices>();
		Vertices start = Nome_Vertice.get(s);
		//Adiciona ponto de partida Lista
		pendente.add(start);
		//Distancia Inicial = 0;
		start.distancia = 0;

		while(!pendente.isEmpty() && visitou.size() <Nome_Vertice.size()){ //&& visitado.size() < Nome_vertice.size())

			Vertices min = EncontraMenor(pendente);
			//adiciona lista de visitados
			visitou.add(min);

			for(Arestas e : min.ArestaAdj){
				//Vertice Destino
				Vertices fim = e.fim;
				//Correção de Distancia Infinita//Dijkstra
				if(fim.distancia == Double.POSITIVE_INFINITY){
					fim.distancia = min.distancia + e.distancia;
					fim.prev = e.fonte;
				}
				//Compara distância e mostra menor
				else if(min.distancia + e.distancia < fim.distancia){ 
					fim.distancia = min.distancia + e.distancia;
					//Reordena distancia para Minimo
					fim.prev = min;
				}
				//Adiciona lista de cidades não visitadas
				if(!visitou.contains(fim) && !pendente.contains(fim)){
					pendente.add(fim);
				}

			}
		}
		System.out.println();		
		System.out.println("Distancia das Cidades para " + start + " é: ");
		for(Vertices v: visitou){
			System.out.print(v+": ");
                        System.out.print(df.format(v.distancia)+" Km\n");
		}
	}

	//Lista prioritária por Index Minimo
	public Vertices EncontraMenor(List<Vertices> l){
		//Distancia Minima Index 1
		double min = l.get(0).distancia;
		//Index Elemento Minimo
		int minIndex = 0;
		//Começo Index 1
		for(int i = 1; i < l.size(); i++){
			if(l.get(i).distancia < min){
				min = l.get(i).distancia;
				minIndex = i;	
			}		
		}
		//Remove Vértice da Lista
		Vertices v = l.remove(minIndex);
		return v;
	}

	public List<Arestas> getDijkstraPath(String s, String t) {
		//Confirma caminho dos elementos através do código Exe_DijkstraPath
		Exe_Dijkstra(s);
		List<Arestas> path = new LinkedList<Arestas>();
		Vertices primeiroVertice = Nome_Vertice.get(s);
		Vertices Vertice_fim = Nome_Vertice.get(t);
		while(Vertice_fim != primeiroVertice){	
                        //Confere o Vertice anterior
			Vertices anterior = Vertice_fim.prev;
			if(anterior == null){
				//Cria caminho vazio
				List<Arestas> emptyPath = new LinkedList<Arestas>();
				return emptyPath;
			}
			//Acha Aresta a partir de lista de Vertice anterior
                        //para Vertice fim e monta o caminho (Rota Cidades)
			for(Arestas e: anterior.ArestaAdj){
				if(e.fim == Vertice_fim ){
					//Insere no primeiro Index
					path.add(0, e);
				}
			}
			//Define novo Vertice fim
			Vertice_fim = anterior;
		}
		return path;
	}


	public void ImprimeListaAdj(){
            DecimalFormat df = new DecimalFormat("#,###.00");
		//Busca chave por Nome Vertice
		for (String u : Nome_Vertice.keySet()) {
			//cria stringbuilder
			StringBuilder sb = new StringBuilder();
			//Adiciona Vertice ao stringbuilder
			sb.append(u);
			//Aponta o StringBuider 
			sb.append(" -> [ ");
			//Imprime Vertices Adjacentes
			for (Arestas e : Nome_Vertice.get(u).ArestaAdj) {
				sb.append(e.fim.nome);
				sb.append("(");
				sb.append(df.format(e.distancia)).append(" Km");
				sb.append(") ");
			}
			sb.append("]");
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] argv) throws IOException {
            DecimalFormat df = new DecimalFormat("#,###.00");
            String[] partida= new String[2];
            //Leitor de txt para HashMap, Localização (x,y) Matriz
            //Lê Vértices e Arestas.
		String txt_vertice = "D:\\Artur\\Trabalhos\\IFMA\\4º Período\\AED II\\Atividade 2\\Atv_grafos_Artur_Fernando\\src\\main\\java\\Questao_5\\Vertices.txt"; 
		String txt_arestas = "D:\\Artur\\Trabalhos\\IFMA\\4º Período\\AED II\\Atividade 2\\Atv_grafos_Artur_Fernando\\src\\main\\java\\Questao_5\\Arestas.txt";

		Dijkstra dijkstra = new Dijkstra();
		String line;
                String line2;
                String line3;
		// Lê cidade Inicial;
                BufferedReader leitor_cid_inicio = new BufferedReader(new FileReader(txt_vertice));
                String[] rotas = new String[3];
                line2 = leitor_cid_inicio.readLine();
                rotas = line2.split(",");

                if (rotas.length > 3) {
                                leitor_cid_inicio.close();
                                throw new IOException("Erro: Vértice -> " + line2);
                }
                leitor_cid_inicio.close();
                //Lê outros vértices
		BufferedReader leitor_vertice = new BufferedReader(new FileReader(txt_vertice));
		while ((line = leitor_vertice.readLine()) != null) {
			String[] parts = line.split(",");
                        
			if (parts.length > 3) {
				leitor_vertice.close();
				throw new IOException("Erro: Vértice -> " + line);
			}
			String NomeCidade = parts[0];
			int x = Integer.valueOf(parts[1]);
			int y = Integer.valueOf(parts[2]);
			Vertices vertex = new Vertices(NomeCidade, x, y);
			dijkstra.adicionaVertice(vertex);
		}
		leitor_vertice.close();

		BufferedReader txt_arestas_Br = new BufferedReader(new FileReader(txt_arestas));
		while ((line = txt_arestas_Br.readLine()) != null) {
			String[] parts = line.split(",");
			if (parts.length > 3) {
				txt_arestas_Br.close();
				throw new IOException("Erro: Aresta -> " + line);
			}
			dijkstra.ArestaBidirecional(parts[0], parts[1], Double.parseDouble(parts[2]));
                        
		}
		txt_arestas_Br.close();

		// Mostra Distancia Calculo Euclidiano
		dijkstra.Soma_DistEuclidiana();

		//Imprime Lista adj Grafo
		dijkstra.ImprimeListaAdj();
                //Cidade Inicio//
		String CidadeInicio = rotas[0];
		//Cidade Fim//Definida aqui:
                String CidadeFim = "SP";//partida[1];
 
		List<Arestas> path = dijkstra.getDijkstraPath(CidadeInicio, CidadeFim);
		System.out.println();
		
		System.out.println("Rota "+CidadeInicio + " para " + CidadeFim + ":");
		double total = 0;
		for(Arestas e: path){
			total = total + e.distancia;
			System.out.println(e + " distancia: " +df.format(e.distancia)+" Km");
		}
		
		System.out.println();
		
		System.out.println("TAMANHO DA ROTA: " + df.format(total)+" Km");
		System.out.println();
		
		System.out.print("Caminho mais curto entre "+CidadeInicio+" e "+CidadeFim+": [A PARTIR DO ALGORITMO DE DijkstraPath]\n-> ");
		System.out.println(path);
	}
}
