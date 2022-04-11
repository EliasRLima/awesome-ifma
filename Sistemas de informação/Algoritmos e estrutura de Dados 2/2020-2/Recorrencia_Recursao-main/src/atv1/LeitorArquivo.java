package atv1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class LeitorArquivo {
	
	public static ArrayList<Ponto> getArray(String link) throws FileNotFoundException{
		ArrayList<Ponto> p = new ArrayList<Ponto>();
		
		Scanner in = new Scanner(new FileReader(link));
		while (in.hasNextLine()) {
		    String line[] = in.nextLine().split(";");
		    Ponto e = new Ponto(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2]);
		    p.add(e);
		}
		
		return p;
	}
}
