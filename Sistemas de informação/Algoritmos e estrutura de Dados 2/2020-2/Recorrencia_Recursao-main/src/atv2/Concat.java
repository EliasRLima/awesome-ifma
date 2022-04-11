package atv2;

import java.util.ArrayList;

public class Concat {
	
	private static ArrayList<ArrayList<String>> possibilidades;
	
	
	public static void listAll(String array[], int k) {
		possibilidades = new ArrayList<ArrayList<String>>();
		ArrayList<String> dp = new ArrayList<String>();
		for(int i = 0; i < array.length;i++) {
			dp.add(array[i]);
		}
		possibilidades.add(dp);
		for(int j = 1; j < k; j++) {
			addNew(array, j);
		}
		
		for(int i = 0; i < possibilidades.size(); i++) {
			dp = possibilidades.get(i);
			for(int j = 0; j < dp.size();j++) {
				System.out.println(dp.get(j));
			}
		}
	}
	
	public static void list(String array[], int k) {
		possibilidades = new ArrayList<ArrayList<String>>();
		ArrayList<String> dp = new ArrayList<String>();
		for(int i = 0; i < array.length;i++) {
			dp.add(array[i]);
		}
		possibilidades.add(dp);
		for(int j = 1; j < k; j++) {
			addNew(array, j);
		}
		
		dp = possibilidades.get(k-1);
		for(int j = 0; j < dp.size();j++) {
			System.out.println(dp.get(j));
		}
	}
	
	private static void addNew(String array[],int idx){
		ArrayList<String> n = new ArrayList<String>();
		ArrayList<String> old = possibilidades.get(idx-1);
		for(int i = 0; i < array.length;i++) {
			for(int j = 0; j < old.size(); j++) {
				n.add(array[i]+old.get(j));
			}
		}
		possibilidades.add(n);
	}
}
