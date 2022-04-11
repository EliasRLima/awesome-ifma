package Sort;

public class Merge {
	
	public static void mergeSort(int[] vetor, int n) {
	    if (n < 2) {
	        return;
	    }
	    int meio = n / 2;
	    int[] e = new int[meio];
	    int[] d = new int[n - meio];

	    for (int i = 0; i < meio; i++) {
	        e[i] = vetor[i];
	    }
	    
	    for (int i = meio; i < n; i++) {
	        d[i - meio] = vetor[i];
	    }
	    
	    mergeSort(e, meio);
	    mergeSort(d, n - meio);
	    merge(vetor, e, d, meio, n - meio);
	}
	
	public static void merge(
			  int[] vetor, int[] l, int[] r, int esquerda, int direita) {
			 
			    int i = 0, j = 0, k = 0;
			    while (i < esquerda && j < direita) {
			        if (l[i] <= r[j]) {
			        	vetor[k++] = l[i++];
			        }
			        else {
			        	vetor[k++] = r[j++];
			        }
			    }
			    while (i < esquerda) {
			    	vetor[k++] = l[i++];
			    }
			    while (j < direita) {
			    	vetor[k++] = r[j++];
			    }
			}
}
