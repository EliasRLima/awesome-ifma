package Atv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author artur
 */
public class txt_vetor {

    public static void main(String[] args) throws IOException{
        Scanner ler = new Scanner(System.in);
        //Scanner ler2 = new Scanner(System.in);
        File arquivo = new File("C:\\Users\\artur\\Desktop\\teste.txt");
//        System.out.println("Digite o nome do arquivo:");
//        String nome = ler.nextLine();
        //ArrayList<String> linhaF = new ArrayList<String>();
        
        //File arquivo = new File(nome);
        
        System.out.println("Digite o delimitador: \nExemplo: [;] [\\n] [,] [.] ");
        String delim = ler.nextLine();
        

        FileReader ler_arquivo = new FileReader(arquivo);
        BufferedReader buff_arq = new BufferedReader(ler_arquivo);
        String texto = buff_arq.readLine(); // O método readLine()apens lê uma linha do arquivo
        
        int tamanho = texto.length();
        String linhaF[] = new String[tamanho];
        String exibir;
        while(buff_arq.ready()){
            exibir = buff_arq.readLine();
            //System.out.println(exibir);
        }
        int j = 0;
        while(texto != null){
            System.out.println(texto);
            for(String str : texto.split(delim)){
                linhaF[j++] = str;                  
            } 
        
            texto = buff_arq.readLine();
            for(int i = 0; i < tamanho; i++){
            System.out.print(linhaF[i]); // Exibe todo o conteúdo armazenado
            }
        buff_arq.close();
        }
       // buff_arq.close();
        
    }
    
}
