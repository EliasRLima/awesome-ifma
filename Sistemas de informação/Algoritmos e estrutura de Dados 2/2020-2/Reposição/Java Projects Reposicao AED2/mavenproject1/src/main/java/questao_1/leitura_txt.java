package questao_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Artur e Fernando
 */
public class leitura_txt {
    public static String[] lerArquivo(String arquivo) throws FileNotFoundException {
        File file = new File(arquivo);
        Scanner sc = new Scanner(file);
        
        StringBuilder str = new StringBuilder();
        
        while (sc.hasNextLine()) str.append(sc.nextLine()).append(",");
        
        return str.toString().split(",", 0);
    }
    
}
