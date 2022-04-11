package Atv2;
import static Atv2.txt_arraylist.to_arraylist;
import java.io.IOException;

/**
 *
 * @author artur
 */
public class QuickSort extends txt_arraylist{

    public static int ordenacao(int a[], int inicio, int fim){  
          
        int esquerda, direita, mistura, posicao, aux;     
        posicao = esquerda = inicio;  
        direita = fim;  
        aux = 0;  
        while(aux != 1){  
            while((a[posicao] <= a[direita]) && (posicao!=direita))  
                direita--;  
            if(posicao==direita)  
                aux =1;  
            else if(a[posicao]>a[direita]){  
                mistura = a[posicao];  
                a[posicao] = a[direita];  
                a[direita] = mistura;  
                posicao = direita;  
            }  
            if(aux!=1){  
                while((a[posicao] >= a[esquerda]) && (posicao!=esquerda))  
                esquerda++;  
                if(posicao==esquerda)  
                    aux =1;  
                if(a[posicao] <a[esquerda]){  
                    mistura = a[posicao];  
                    a[posicao] = a[esquerda];  
                    a[esquerda] = mistura;  
                    posicao = esquerda;  
                }  
            }  
        }  
        return posicao;  
    }  
    static void quickSort(int a[], int inicio, int fim){  
          
        int posicao;  
        
        if(inicio<fim){  
            posicao = ordenacao(a, inicio, fim);  
            quickSort(a, inicio, posicao-1);  
            quickSort(a, posicao+1, fim);  
        }  
    }  
    public static void main(String[] args) throws IOException {  
        txt_arraylist texto = new txt_arraylist();
  
        txt_arraylist.to_arraylist();
        int i;  
        int[] array = {1,20,3,4,50,6,7,80,9,10};
        int tam = array.length-1;
        quickSort(array, 0, tam);  
        System.out.println("Array: "+tam);  

        for(i=0;i<tam;i++){
            System.out.println("");
            System.out.print(" "+array[i]);  
        }
    }
}
   