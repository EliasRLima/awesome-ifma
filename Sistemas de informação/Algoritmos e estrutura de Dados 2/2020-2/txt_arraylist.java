package Atv2;

import static Atv2.txt_arraylist.to_arraylist;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author artur
 */
public class txt_arraylist {
    public static void to_arraylist() throws IOException{
        Scanner ler = new Scanner(System.in);
        //File arquivo = new File("C:\\Users\\artur\\Desktop\\teste.txt");
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
            System.out.print(linhaF); // Exibe todo o conteúdo armazenado
            buff_arq.close();
        }
    }


    public static void main(String[] args) throws IOException {
        
        to_arraylist();// Exibe todo o conteúdo armazenado

    }
    
}
