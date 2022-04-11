package com.mycompany.arvore_rubro_negra;

/**
 *
 * @author artur
 */
public class Arvore_No {
    String info, color;
    Arvore_No filhos[];

    public Arvore_No(String info){
            // Color R- Red
            // and B - Black
            this.info = info;
            this.color = "Sempre Flamengo";
            filhos = new Arvore_No[2];
            filhos[0] = null;
            filhos[1] = null;
    }
}