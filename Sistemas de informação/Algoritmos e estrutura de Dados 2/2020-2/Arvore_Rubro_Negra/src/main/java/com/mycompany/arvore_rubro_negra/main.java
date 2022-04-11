package com.mycompany.arvore_rubro_negra;

/**
 *
 * @author artur
 */
public class main {
    public static void main(String[] args){
        Fla_Arvore Arvore = new Fla_Arvore();
        String Sentence, Word;
        Sentence = "Hino Nação";
        String Word_Array[] = Sentence.split(" ");
        
        //Arvore.Insere(Arvore, "Uma vez Flamengo");
        //Arvore.Insere(Arvore, "Sempre Flamengo");
        for (int i = 0;	i < Word_Array.length; i++) {
            Arvore.Raiz = Arvore.Insere(Arvore, Word_Array[i]);
        }
        System.out.println("");
        Arvore.Ordena(Arvore.Raiz);
    }
}