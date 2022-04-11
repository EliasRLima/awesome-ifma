package Seminario_Arvores;

import java.util.Random;


/*
Instituto Federal do Maranhão
Disciplina: AED II
Professor: Helder
Equipe: Artur, Elias, Fernando e Francisco.
Arvore AVL
*/
public class Pseudo_codigo {

    No raiz;
 
    // Define altura da arvore_avl
    int altura(No N) {
        if (N == null)
            return 0;
 
        return N.altura;
    }
 
    // Função que consegue a maoir(max) integer
    int max_int(int a, int b) {
        return (a > b) ? a : b;
    }

    /* Função que faz a Rotação da Arvore para a Direita
    O que faz da Arvore AVL*/
    No rodar_direita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;
 
        // Rotação da Arvore AVL
        x.direita = y;
        y.esquerda = T2;
 
        //  Nova Altura -> Base Max_int
        y.altura = max_int(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max_int(altura(x.esquerda), altura(x.direita)) + 1;
 
        // Recursão -> Volta Nova Raiz
        return x;
    }
 
    /* Função que faz a Rotação da Arvore para a Esquerda
    O que faz da Arvore AVL*/
    No rodar_esquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;
 
        // Rotação da Arvore AVL
        y.esquerda = x;
        x.direita = T2;
 
        //  Nova Altura -> Base Max_int
        x.altura = max_int(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max_int(altura(y.esquerda), altura(y.direita)) + 1;
 
        // Recursão -> Volta novo No
        return y;
    }
 
    // Monta Arvore
    int monta_arvore(No N) {
        if (N == null)
            return 0;
 
        return altura(N.esquerda) - altura(N.direita);
    }
 
    No insere(No no, int chave) {
 
        //Inserção Arvore Binaria
        if (no == null)
            return (new No(chave));
 
        if (chave < no.chave)
            no.esquerda = insere(no.esquerda, chave);
        else if (chave > no.chave)
            no.direita = insere(no.direita, chave);
        else // Impede que haja mais de uma chave
            return no;
 
        //Pega nova altura do no anterior
        no.altura = 1 + max_int(altura(no.esquerda),altura(no.direita));
 
        //Verifica se no esta desigual
        int equi = monta_arvore(no);
 
        // Se o no está desigual, são possíveis 4 casos:
        if (equi > 1 && chave < no.esquerda.chave){
            return rodar_direita(no);
        }
        if (equi < -1 && chave > no.direita.chave){
            return rodar_esquerda(no);
        }
        if (equi > 1 && chave > no.esquerda.chave) {
            no.esquerda = rodar_esquerda(no.esquerda);
            return rodar_direita(no);
        }
 
        if (equi < -1 && chave < no.direita.chave) {
            no.direita = rodar_direita(no.direita);
            return rodar_esquerda(no);
        }
        //Recursão -> Retorna ao ponteiro(no)
        return no;
    }
 
    //Imprime de maneira Ordenada, e imprime altura
    void Ordenacao(No no) {
        if (no != null) {
            System.out.print(no.chave + " ");
            Ordenacao(no.esquerda);
            Ordenacao(no.direita);
        }
    }
    /* Questão
    boolean Confirma_AVL(No N){
        if((altura(N.esquerda) - altura(N.direita)) == -1 || (altura(N.esquerda) - altura(N.direita) == 1)){
            System.out.println("Arvore é AVL");
        }
        return false;        
    }*/
    public static void main(String[] args) {
        Arvore_AVL arvore_avl = new Arvore_AVL();
        Random random = new Random();
        int array_int[] = new int[10000]; //Teste Vetor com 100 numeros
        /*
        int array_int[] = new int[1000]; //Teste Vetor com 1000 numeros
        int array_int[] = new int[10000]; //Teste Vetor com 10000 numeros
        */
        int limite = 10000;
        System.out.print("Vetor: [");
        for (int i=0; i<array_int.length; i++) {
             array_int[i] = random.nextInt(limite); // Gera números aleatórios com limite 50.
             System.out.print(" "+array_int[i]); 
        }
        System.out.print("]");
        for(int i=0; i<array_int.length;i++){
            arvore_avl.raiz = arvore_avl.insere(arvore_avl.raiz, array_int[i]);
        }
        System.out.println("\nÁrvore_AVL:");
        arvore_avl.Ordenacao(arvore_avl.raiz);
    }
    
}
