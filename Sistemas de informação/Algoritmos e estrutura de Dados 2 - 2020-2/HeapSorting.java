package Atv2;

import java.io.IOException;
import static java.lang.Thread.sleep;

/**
 *
 * @author artur
 */
public class HeapSorting extends txt_arraylist {
    static void heapify(int[] array, int tam, int i){  
        int maior = i;    
        int esquerda = 2*i + 1;    
        int direita = 2*i + 2;    
        int aux;  

        if (esquerda < tam && array[esquerda] > array[maior])  
            maior = esquerda;  
            
        if (direita < tam && array[direita] > array[maior])  
            maior = direita;  

        if (maior != i){  
            aux = array[i];  
            array[i]= array[maior];   
            array[maior] = aux;  
            heapify(array, tam, maior);  //recursão

        }  
}  
  
    static void heapSort(int[] array, int tam){  
        int i;  
        int aux;  
        for (i = tam / 2 - 1; i >= 0; i--)  //começo do algoritimo
            heapify(array, tam, i);  //Aplicação da propriedade Heap
        for (i=tam-1; i>=0; i--){  
            aux = array[0];  
            array[0]= array[i];   
            array[i] = aux;  
            heapify(array, i, 0);  
            //Para Exibição
            System.out.print(" "+array[i] + " ");
            for(int s=0; s<3; s++){
                System.out.print(".");
                //sleep(1000);
            }
            //Fim Exibição
        }  
    }  
    
    public static void main(String[] args) throws IOException{
        txt_arraylist texto = new txt_arraylist();  
        txt_arraylist.to_arraylist();
        
        int[] array = new int[10];
        int tam = array.length;
        
        System.out.println("Tamanho Vetor: "+tam);
        System.out.println("Vetor Entrada: ");
        for(int i=0; i<tam; i++){
            array[i] = (int) Math.floor(Math.random()*tam); //Gera um vetor aleatório e automático
            System.out.print(array[i]+" ");
        }
        System.out.println("\n\nProcessando Entradas: ");
        
        heapSort(array, tam);  

        System.out.println("\n\nVetor Saída: ");  
        for (int i=0; i<tam; ++i){ 
            System.out.print(array[i]+" ");  
        }
        
    }
}
 