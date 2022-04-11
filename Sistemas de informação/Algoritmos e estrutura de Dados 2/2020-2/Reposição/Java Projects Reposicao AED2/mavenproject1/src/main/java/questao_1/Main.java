package questao_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Artur e Fernando
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
   
        Scanner ler = new Scanner(System.in);
//        File arquivo = new File("D:\\Artur\\Trabalhos\\IFMA\\4º Período\\AED II\\Java Projects AED2\\mavenproject1\\src\\main\\java\\questao_1\\Entrada de Dados.txt");
        System.out.println("Digite o nome do arquivo:");
        String nome = ler.nextLine();
        ArrayList linhaF = new ArrayList<String>();
        
        String[] str = leitura_txt.lerArquivo(nome);
        int tamanho = str.length;        
        //teste
        System.out.println("Array Desordenado: ");
        for(int i = 0; i<tamanho; i++)
            System.out.print("-> "+str[i]);      
        int[] array_int = new int[tamanho];        
        for(int i = 0; i < tamanho; i++) {
            array_int[i] = Integer.parseInt(String.valueOf(str[i].replace(" ","")));
        }    
        HeapSorting.heapSort(array_int, tamanho);
        System.out.println("\nArray Ordenado: ");
        for(int i = 0; i<tamanho; i++){
            System.out.print(" "+array_int[i]);
        }
                
    }
}