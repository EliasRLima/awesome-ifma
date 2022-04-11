package Questao_4;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author artur e Fernando
 */

public class Grafo_Bipartido {
    private Set<Integer> Marca = new HashSet<>();
    private Map<Integer, Set<Integer>> vizinhos = new HashMap<>();
    private boolean Eh_Bipartido = true;
    private Map<Integer, Boolean> vermelho = new HashMap<>();

    public Set<Integer> Ligacoes() {
        return vizinhos.keySet();
    }

    public int tamanho() {
        return Ligacoes().size();
    }

    public long tamanho_aresta() {
        return vizinhos.values().stream()
                .collect(Collectors.summingLong(Set::size)) / 2;
    }
    public void adiciona_aresta(int a, int b) {
        vizinhos.computeIfAbsent(a, k -> new HashSet<Integer>()).add(b);
        vizinhos.computeIfAbsent(b, k -> new HashSet<Integer>()).add(a);
    }

//	static void adiciona_aresta(Map<Integer, Set<Integer>> adj, int a, int b) {
//            if (!adj.containsKey(a)) adj.put(a, new HashSet());
//            if (!adj.containsKey(b)) adj.put(b, new HashSet());
//            adj.get(a).add(b);
//            adj.get(b).add(a);
//       }
    
    public void cor_grafo() {
        for(Integer s : vizinhos.keySet()) {
            if(!Marca.contains(s)) {
                bfs(s);
            }
        }
    }
    
    private void bfs(Integer s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        Marca.add(s);
        vermelho.put(s, true);
        while(!queue.isEmpty()) {
            Integer v = queue.poll();
            for(Integer w : vizinhos.get(v)) {
                if(!Marca.contains(w)) {
                    Marca.add(w);
                    queue.add(w);
                    vermelho.put(w, !vermelho.get(v));
                } else if(vermelho.get(v) == vermelho.get(w)) {
                    this.Eh_Bipartido = false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
    Grafo_Bipartido g = new Grafo_Bipartido();
    Map<Integer, Set<Integer>> adj = new HashMap<>();

        File input = new File("D:\\Artur\\Trabalhos\\IFMA\\4º Período\\AED II\\Atividade 2\\Atv_grafos_Artur_Fernando\\src\\main\\java\\com\\mycompany\\atv_grafos_artur_fernando\\Dados txt.txt"); //Define the input file with "filename"
        try {
            Scanner reader = new Scanner(input); //read in the file

            while (reader.hasNextLine()) {
                String[] nums = reader.nextLine().split(" ");
                for (int i = 0; i < 7; i++) {
                    g.adiciona_aresta(i, i + 1);
                    g.adiciona_aresta(i, i + 2);
                }
                for (int i = 7; i < 17; i++) {
                     g.adiciona_aresta(i, i + 1);
                }
            }

            g.cor_grafo();
            System.out.println("Grafo {");
            g.vermelho.entrySet().forEach(i -> {
                System.out.println(i.getKey() + "[Cor=" + (i.getValue() ? "Vermelho" : "Azul") + "];");
            });
            g.vizinhos.keySet().stream().forEach(i -> {Stream.of(g.vizinhos.get(i)).flatMap(j -> j.stream()).forEach(k -> System.out.print(i + "->" + k + ";\n"));});
            System.out.println("}");
            System.out.println("Numero de Ligações: " + g.tamanho());
            System.out.println("Numero de Arestas: " + g.tamanho_aresta());
            System.out.println("O gráfico é Bipartido: " + g.Eh_Bipartido);
            reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    // change the number of points and edges here.
    
    
    }

}