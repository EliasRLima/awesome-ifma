package Sort;

public class Shell {
	
	public static void sort(int vetor[]) {
	    int n = vetor.length;

	    for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
	        for (int i = intervalo; i < n; i++) {
	            int valor = vetor[i];
	            int j = i;
	            while (j >= intervalo && vetor[j - intervalo] > valor) {
	                vetor[j] = vetor[j - intervalo];
	                j -= intervalo;
	            }
	            vetor[j] = valor;
	        }
	    }
	}
}
