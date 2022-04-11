package Sort;

public class Tim {
     
	static int MIN = 32; 
	  
    private static int minima(int n) 
    { 
        assert n >= 0; 
        
        int r = 0; 
        while (n >= MIN)  
        { 
            r |= (n & 1); 
            n >>= 1; 
        } 
        return n + r; 
    } 
  
    public static void insertionSort(int[] vetor, int esquerda, 
                                     int direita) 
    { 
        for (int i = esquerda + 1; i <= direita; i++)  
        { 
            int temp = vetor[i]; 
            int j = i - 1; 
            while (j >= esquerda && vetor[j] > temp)  
            { 
                vetor[j + 1] = vetor[j]; 
                j--; 
            } 
            vetor[j + 1] = temp; 
        } 
    } 
  
    public static void merge(int[] vetor, int l, int m, int r) 
    { 
        int len1 = m - l + 1, len2 = r - m; 
        int[] esquerda = new int[len1]; 
        int[] direita = new int[len2]; 
        for (int x = 0; x < len1; x++)  
        { 
            esquerda[x] = vetor[l + x]; 
        } 
        for (int x = 0; x < len2; x++)  
        { 
            direita[x] = vetor[m + 1 + x]; 
        } 
  
        int i = 0; 
        int j = 0; 
        int k = l; 
  
        while (i < len1 && j < len2)  
        { 
            if (esquerda[i] <= direita[j])  
            { 
                vetor[k] = esquerda[i]; 
                i++; 
            } 
            else { 
                vetor[k] = direita[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < len1)  
        { 
            vetor[k] = esquerda[i]; 
            k++; 
            i++; 
        } 
  
        while (j < len2)  
        { 
            vetor[k] = direita[j]; 
            k++; 
            j++; 
        } 
    } 
  
    public static void timSort(int[] vetor, int n) 
    { 
        int minRun = minima(MIN); 
        
        for (int i = 0; i < n; i += minRun) 
        { 
            insertionSort(vetor, i, 
                          Math.min((i + 31), (n - 1))); 
        } 
  
        for (int size = minRun; size < n; size = 2 * size)  
        { 

            for (int esquerda = 0; esquerda < n;  
                                 esquerda += 2 * size)  
            { 
  
                int meio = esquerda + size - 1; 
                int direita = Math.min((esquerda + 2 * size - 1), 
                                     (n - 1)); 
  
                merge(vetor, esquerda, meio, direita); 
            } 
        } 
    } 
}
