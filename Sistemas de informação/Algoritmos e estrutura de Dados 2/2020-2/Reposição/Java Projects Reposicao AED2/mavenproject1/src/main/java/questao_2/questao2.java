package questao_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Artur e Fernando
 */
public class questao2 {
    public static String lerArquivo(String arquivo) throws FileNotFoundException {
        File file = new File(arquivo);
        Scanner sc = new Scanner(file).useDelimiter("\n");
        
        if (sc.hasNext()) {
            return sc.next();
        } else {
            return "";
        }
    }
    
    public static String[] ordenar(String str) {
        String[] arr = str.split(" ", 0);
        String temp;
        int tam = arr.length;
        
        for (int i = 0; i < tam; i++)  {
            for (int j = i + 1; j < tam; j++) { 
                if (arr[i].compareTo(arr[j]) > 0) 
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        return arr;
    }
}
