package Seminario_Arvores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Arvore_AVL arvore_avl = new Arvore_AVL();
        Scanner ler = new Scanner(System.in);
        //File arquivo = new File("C:\\Users\\artur\\Desktop\\Txt Exemplo - URSAL.txt");
        System.out.println("Digite o nome do arquivo:");
        String nome = ler.nextLine();
        ArrayList linhaF = new ArrayList<String>();
        
        File arquivo = new File(nome);
        
        System.out.println("Digite o delimitador: \nExemplo: [;] [\\n] [,] [.] ");
        String delim = ler.nextLine();
        
        FileReader ler_arquivo = new FileReader(arquivo);
        BufferedReader buff_arq = new BufferedReader(ler_arquivo);
        String texto = buff_arq.readLine(); //lê uma linha do arquivo
        
        int tamanho = texto.length();
        String exibir;
        while(buff_arq.ready()){
            exibir = buff_arq.readLine();
            //System.out.println(exibir);//Exibir conteúdo não processado txt.
        }
        int j = 0;
        while(texto != null){
            linhaF.addAll(Arrays.asList(texto.split(delim))); 
            
            texto = buff_arq.readLine();
            buff_arq.close();
        }
        String[] array = (String[]) linhaF.toArray(new String[tamanho]);
        
        int[] array_int = new int[tamanho];      
        int tamanho_array = 0;
        for(int i=0;i<tamanho;i++){ 
            if(array[i] != null)
                tamanho_array++;        
        }

        System.out.println("\nArray Desordenado: ");
        for(int i = 0; i<tamanho_array; i++){
            System.out.print(" "+array[i]);
        }
        for(int i = 0; i < tamanho_array; i++) {
                array_int[i] = Integer.parseInt(array[i]);
        }
        
        for(int i=0; i<tamanho_array;i++){
            arvore_avl.raiz = arvore_avl.insere(arvore_avl.raiz, array_int[i]);
        }

        System.out.println("\nÁrvore_AVL:");
        arvore_avl.Ordenacao(arvore_avl.raiz);

    }
}
    