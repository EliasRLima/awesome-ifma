package Questao_1;


import java.io.*;
import java.util.*;


class Grafo{
	private int V; // Numero de Vertices
	private LinkedList<Integer> adj[]; //Lista Adjacente
	// Construtor
	Grafo(int v){
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	// Função de Adição de Arestas
	static void adiciona_aresta(Map<Integer, Set<Integer>> adj, int u, int w) {
            if (!adj.containsKey(u)) adj.put(u, new HashSet());
            if (!adj.containsKey(w)) adj.put(w, new HashSet());
            adj.get(u).add(w);
            adj.get(w).add(u);
       }
        static void imprime_dsf(Map<Integer, Set<Integer>> adj) {
            for (int u : adj.keySet()) {
                for (int w : adj.get(u)) {
                    System.out.print(w+"->");
                }
            }
            System.out.print("FIM");
        }
	void imprime_bsf(int s){
		boolean visited[] = new boolean[V];
		// Cria Fila BSF
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s]=true;
		queue.add(s);

		while (queue.size() != 0){
			s = queue.poll();
			System.out.print(s+"->");
                        
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()){
				int n = i.next();
				if (!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

    void imprime_bsf(Map<Integer, Set<Integer>> adj) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }	
}