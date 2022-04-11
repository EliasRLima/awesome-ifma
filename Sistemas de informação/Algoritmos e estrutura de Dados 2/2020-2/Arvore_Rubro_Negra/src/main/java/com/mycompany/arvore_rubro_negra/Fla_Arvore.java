package com.mycompany.arvore_rubro_negra;

/**
 *
 * @author artur
 */

import static java.lang.Integer.max;

public class Fla_Arvore {
    Arvore_No Raiz = null;
    // Função para Calcular a Altura da Árvore
    int Altura_arv(Arvore_No Raiz){
        int esquerda, direita;

        if (Raiz == null || (Raiz.filhos == null && Raiz.filhos[1] == null)) {
                return 0;
        }
        esquerda = Altura_arv(Raiz.filhos[0]);
        direita = Altura_arv(Raiz.filhos[1]);

        return (max(esquerda, direita) + 1);
    }

    // checagem dir = 0
    int checagem(int dir){
        return dir == 0 ? 1 : 0;
    }

    // Função pra checar a cor do Nó
    boolean Rubro(Arvore_No No){
        return No != null && No.color.equals("Rubro Negra");
    }

    // Função da Rotação Simples
    Arvore_No Rotacao_Simples(Arvore_No No, int dir){
        Arvore_No temporario = No.filhos[checagem(dir)];
        No.filhos[checagem(dir)] = temporario.filhos[dir];
        temporario.filhos[dir] = No;
        Raiz.color = "Sempre Flamengo"; //"Rubro";
        temporario.color = "Uma vez Flamengo"; //"Negra";

        return temporario;
    }

    // Função da Rotação Dupla
    Arvore_No Rotacao_Dupla(Arvore_No No, int dir){
        No.filhos[checagem(dir)] = Rotacao_Simples(No.filhos[checagem(dir)], checagem(dir));
        return Rotacao_Simples(No, dir);
    }

    // Função de Inserção
    Arvore_No Insere(Fla_Arvore arvore, String info){
        if (arvore.Raiz == null) {
            arvore.Raiz = new Arvore_No(info);
            if (arvore.Raiz == null)
                    return null;
        }
        else {
            // Raiz temporaria
            Arvore_No temporario = new Arvore_No("");

            // Nós pais = p, Nós avós = g
            Arvore_No g, t;
            Arvore_No p, q;

            int dir = 0, ultimo = 0;
            t = temporario;
            g = p = null; //Avós = pais
            t.filhos[1] = arvore.Raiz;

            q = t.filhos[1];
            while (true) {

                if (q == null) {
                        // Insere Nó Raiz
                        q = new Arvore_No(info);
                        p.filhos[dir] = q;
                }

                // Irmão = Rubro
                else if (Rubro(q.filhos[0]) && Rubro(q.filhos[1])) {
                    // Nova cor, filhos = Rubro
                    q.color = "Sempre Flamengo"; //"Rubro";
                    q.filhos[0].color = "Uma vez Flamengo"; // "Negra";
                    q.filhos[1].color = "Uma vez Flamengo"; //"Negra";
                }

                if (Rubro(q) && Rubro(p)) {
                    // Corrige problema Rubro-Rubro
                    int dir2;
                    if (t.filhos[1] == g) {
                        dir2 = 1;
                    }
                    else {
                        dir2 = 0;
                    }

                    // Se filhos e pais são:
                    // esquerda-esquerda ou direita-direita dos avós
                    if (q == p.filhos[ultimo]) {
                            t.filhos[dir2] = Rotacao_Simples(g, ultimo == 0 ? 1 : 0);
                    }
                    // Se são opostos
                    else {
                        t.filhos[dir2]= Rotacao_Dupla(g,ultimo == 0 ? 1 : 0);
                    }
                }
                // Checagem de posição do Nó para a correção se necessário
                if (q.info.equals(info)) {
                        break;
                }
                ultimo = dir;
                // Busca o caminho para a Rotação a esquerda ou direita
                dir = q.info.compareTo(info) < 0 ? 1 : 0;
                if (g != null) {
                    t = g;
                }
                // Reposiciona Ponteiros
                g = p;
                p = q;
                q = q.filhos[dir];
            }
            arvore.Raiz = temporario.filhos[1];
        }

        // Transforma Raiz em Negra
        arvore.Raiz.color = "Uma vez Flamengo";//"Negra";
        return arvore.Raiz;
    }

    // Imprime Nós em Ordem
    void Imprime(Arvore_No raiz, int i){
            if (raiz == null) {
                    return;
            }
            if (i == 1) {
                System.out.print("| "+ raiz.info+ " | "	+ raiz.color + " |");

                if (raiz.filhos[0] != null) {
                        System.out.print(" "+ raiz.filhos[0].info + " |");
                }
                else {
                        System.out.print(" "+ "NULL"+ " |");
                }
                if (raiz.filhos[1] != null) {
                        System.out.print(" "+ raiz.filhos[1].info	+ " |");
                }
                else {
                        System.out.print(" "+ "NULL"+ " |");
                }
                System.out.print(" ");

                return;
            }
            Imprime(raiz.filhos[0],i - 1);
            Imprime(raiz.filhos[1],i - 1);
    }

    // Função de Ordenação de Nível
    void Ordena(Arvore_No raiz){
        int i;

        for (i = 1; i < Altura_arv(raiz) + 1; i++) {
        Imprime(raiz, i);
        System.out.print("\n\n");
        }
    }

}
