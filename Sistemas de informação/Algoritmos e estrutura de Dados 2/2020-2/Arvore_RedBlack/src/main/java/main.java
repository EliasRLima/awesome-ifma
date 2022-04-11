public class main {

    public static void main(String[] args) {
        Arvore_Rubro_Negra bst = new Arvore_Rubro_Negra();
        bst.Insere(55);
        bst.Insere(40);
        bst.Insere(65);
        bst.Insere(60);
        bst.Insere(75);
        bst.Insere(57);
        bst.Imprime_Arvore();

        System.out.println("\nElemento depois do elemento deletado:");
        //Deleta elemento para teste de funcionamento;
        bst.delete_No(40);
        bst.Imprime_Arvore();
        int tam = bst.tam/2;
        System.out.println("Número de elementos da Arvore: "+tam);
    
    }
    
}
