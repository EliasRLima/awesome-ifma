package Atv1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TableHash {
      
	private HashMap<Integer, String> T = new HashMap<Integer, String>(); //HashMap é uma versão avançada e aprimorada da Hashtable. //usei HashMap pois este permite valores null enquanto implementa o hashCode
	private HashMap<Integer, String> S = new HashMap<Integer, String>();
	
	public TableHash(String linkT, String linkS) throws FileNotFoundException {
		arquivo2Table(T, linkT);
		arquivo2Table(S, linkS);
	}
	
	private void arquivo2Table(HashMap<Integer, String> n,String link) throws FileNotFoundException {
		int idx = 1;
		Scanner in = new Scanner(new FileReader(link));
		while (in.hasNextLine()) {
			String aux = in.nextLine().toString();
		    n.put(idx, aux);
		    idx++;
		}
	}

	public HashMap<Integer, String> getT() {
		return T;
	}

	private void setT(HashMap<Integer, String> t) {
		T = t;
	}

	public HashMap<Integer, String> getS() {
		return S;
	}

	private void setS(HashMap<Integer, String> s) {
		S = s;
	}
	
	public boolean verificarSubconjunto(HashMap<Integer, String> conjunto, HashMap<Integer, String> subconjunto) {
		for(Map.Entry map : subconjunto.entrySet()) {
			if(!conjunto.containsValue(map.getValue().toString())) {
				return false;
			}
		}
		return true;
	}
	
	public void showS() {
		System.out.println("S => {");
		for(Map.Entry map : this.S.entrySet()) {
			System.out.println("\tPosicao: " + map.getKey() + " Valor: " +map.getValue());
		}
		System.out.println("}\n");
	}
	
	public void showT() {
		System.out.println("T => {");
		for(Map.Entry map : this.T.entrySet()) {
			System.out.println("\tPosicao: " + map.getKey() + " Valor: " + map.getValue());
		}
		System.out.println("}\n");
	}
	
	
}
