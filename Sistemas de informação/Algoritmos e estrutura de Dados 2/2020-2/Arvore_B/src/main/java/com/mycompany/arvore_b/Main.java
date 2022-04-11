package com.mycompany.arvore_b;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Arvore_B b = new Arvore_B(3);
        int i = 1, cod_soma;
        int resp, qtd=0, vendido=0;
        float lucro=0, montante=0, montante2=0;
        int[] valor = new int[1000];
        String[] Tipo = new String[500];
        String[] Cor = new String[30];
        do{
//            for(int cls = 0; cls < 10; cls++)
//                System.out.println("");
            System.out.println("#################Loja Mundo das Camisas############################");
            System.out.println("[1] - Inserir");
            System.out.println("[2] - Montante em Estoque");
            System.out.println("[3] - Pesquisar Produto");
            System.out.println("[4] - Confirma Compra");
            System.out.println("[5] - Montante vendido");
            System.out.println("[6] - Sair");
            System.out.println("#################Loja Mundo das Camisas############################");
            resp = ler.nextInt();
            if(resp == 1){
                b.Insere(i);
                i++;
                System.out.println("Digite tipo da camisa :");
                String tipo = ler.next();
                Tipo[i] = tipo;
                System.out.println("Digite a cor da camisa :");
                String cor = ler.next();
                Cor[i] = cor;
                System.out.println("Digite o preço do Produto: ");
                int preco = ler.nextInt();
                valor[i] = preco; 
                qtd++;
            }
            if(resp == 2){
                montante=montante-montante2;
                for(int j=1; j<=qtd+1;j++)
                    montante =montante + valor[j];
                System.out.println("Quantidade de Camisas em Estoque: "+qtd);
                System.out.println("Valor de Camisas em Estoque: R$"+montante);
            }
            if(resp == 3){
                System.out.println("Produtos disponíveis :");
                b.Imprime();
                System.out.println("");
                System.out.println("Digite Código do Produto");
                int codigo = ler.nextInt();
                if (b.Possui(codigo)) {
                    codigo = i;
                    System.out.println("#########Descrição do produto#############");
                    System.out.println("Tipo: "+Tipo[i]);
                    System.out.println("Cor:"+Cor[i]);
                    System.out.println("Preço: R$ "+valor[i]);
                    System.out.println("##########################################");
                } else {
                System.out.println("\nProduto não cadastrado");
                }
            }if(resp==4){
                System.out.print("Produtos no Estoque: ");
                b.Imprime();
                System.out.println("\nDigite o Código do Produto: ");
                cod_soma = ler.nextInt();
                if (b.Possui(cod_soma)) {
                    vendido++;
                    lucro = lucro+valor[cod_soma];
                    qtd--;
                    montante2 = montante-lucro;
                    System.out.println("Quantidade de Camissas Vendidas:"+vendido);
                    System.out.println("Lucro com camisas vendidas: R$"+lucro);
                    
                }else{
                    System.out.println("\nProduto não cadastrado");
                }
            }else{
                System.out.println("Quantidade de Camissas Vendidas: "+vendido);
                System.out.println("Lucro com camisas vendidas: R$ "+lucro);
            }
        }while(resp!=6);
    }    
}
