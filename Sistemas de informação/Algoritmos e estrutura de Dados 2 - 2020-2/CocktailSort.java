package Atv2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author artur
 */
public class CocktailSort extends txt_arraylist{
    static int temp;   
static void Cocktail(int a[], int n){  
    boolean mistura = true;  
    int inicio = 0;
    int i;  
    int fim = n - 1;  
   
    while (mistura) {  
            mistura = false;  
        for (i = inicio; i < fim; ++i) {  
            if (a[i] > a[i + 1]){  
                temp = a[i];  
                a[i]=a[i+1];  
                a[i+1]=temp;                  
                mistura = true;  
            }  
        }  
        if (!mistura)  
           break;  
        mistura = false;  
        for (i = fim - 1; i >= inicio; --i) {  
            if (a[i] > a[i + 1]){  
                temp = a[i];  
                a[i]=a[i+1];  
                a[i+1]=temp;  
                mistura = true;  
            }  
        }  
               inicio++;  
    }  
}  

public static void main(String[] args) throws IOException {        
    int[] array={1,20,3,40,5,6,7,8,90,10};
    int i;  
    int tam = array.length-1;
    
    txt_arraylist texto = new txt_arraylist();
    txt_arraylist.to_arraylist();
    
    Cocktail(array, tam);  
    System.out.println("Array: "+tam);  
        for (i = 0; i < tam; i++)
        //System.out.println("|");
        System.out.print(array[i]+" ");    
    }
}