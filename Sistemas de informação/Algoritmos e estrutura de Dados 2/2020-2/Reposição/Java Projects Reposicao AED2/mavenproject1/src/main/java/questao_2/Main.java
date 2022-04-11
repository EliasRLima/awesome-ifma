package questao_2;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Artur e Fernando
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo:");
        String nome = ler.nextLine();
        //String nome = "D:\\Artur\\Trabalhos\\IFMA\\4º Período\\AED II\\Java Projects AED2\\mavenproject1\\src\\main\\java\\questao_2\\dados.txt";
        String str = questao2.lerArquivo(nome);
        String[] arr = questao2.ordenar(str);
        
        System.out.println("Em ordem:");
        for (String s : arr) System.out.printf("%s ", s);
    }
}
