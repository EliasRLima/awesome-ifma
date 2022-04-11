package Questao_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author artur e Fernando
 */
public class Main {

    public static void main(String args[]) throws FileNotFoundException{
        Grafo g = new Grafo(10);
        System.out.println("--------------BFS------------------");
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        File input = new File("D:\\Artur\\Trabalhos\\IFMA\\4º Período\\AED II\\Atividade 2\\Atv_grafos_Artur_Fernando\\src\\main\\java\\com\\mycompany\\atv_grafos_artur_fernando\\Dados txt.txt"); //Define the input file with "filename"
        try {
            Scanner reader = new Scanner(input); //read in the file

            while (reader.hasNextLine()) {
                String[] nums = reader.nextLine().split(" ");
                g.adiciona_aresta((Map<Integer, Set<Integer>>) adj, Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
                g.imprime_bsf(Integer.parseInt(nums[1]));
            }
            System.out.print("FIM");
            System.out.println("\n--------------DFS------------------");
            g.imprime_dsf((Map<Integer, Set<Integer>>) adj);
            reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }        
    }
}
