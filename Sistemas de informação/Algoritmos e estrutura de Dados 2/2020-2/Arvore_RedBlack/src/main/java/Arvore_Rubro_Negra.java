// Implementação Árvore RedBlack

  
public class Arvore_Rubro_Negra {
    private No raiz;
    private No TNULL;
    int tam=0;
  
    // Primeira Ordenação
    private void ordena_1(No no) {
      if (no != TNULL) {
        System.out.print(no.info + " ");
        ordena_1(no.esquerda);
        ordena_1(no.direita);
      }
    }
  
    // Segunda Ordenação
    private void Ordena_2(No no) {
      if (no != TNULL) {
        Ordena_2(no.esquerda);
        System.out.print(no.info + " ");
        Ordena_2(no.direita);
      }
    }
  
    // Ultima Ordenacao
    private void Ordenacao_final(No no) {
      if (no != TNULL) {
        Ordenacao_final(no.esquerda);
        Ordenacao_final(no.direita);
        System.out.print(no.info + " ");
      }
    }
  
    // Faz uma busca a partir da chave
    private No buscaChave(No no, int chave) {
      if (no == TNULL || chave == no.info) {
        return no;
      }
  
      if (chave < no.info) {
        return buscaChave(no.esquerda, chave);
      }
      return buscaChave(no.direita, chave);
    }
  
    // Balanceia a arvore após deletar um elemento
    private void fixDelete(No x) {
      No s;
      while (x != raiz && x.cor == 0) {
        if (x == x.pai.esquerda) {
          s = x.pai.direita;
          if (s.cor == 1) {
            s.cor = 0;
            x.pai.cor = 1;
            rotacao_esquerda(x.pai);
            s = x.pai.direita;
          }
  
          if (s.esquerda.cor == 0 && s.direita.cor == 0) {
            s.cor = 1;
            x = x.pai;
          } else {
            if (s.direita.cor == 0) {
              s.esquerda.cor = 0;
              s.cor = 1;
              rotacao_direita(s);
              s = x.pai.direita;
            }
  
            s.cor = x.pai.cor;
            x.pai.cor = 0;
            s.direita.cor = 0;
            rotacao_esquerda(x.pai);
            x = raiz;
          }
        } else {
          s = x.pai.esquerda;
          if (s.cor == 1) {
            s.cor = 0;
            x.pai.cor = 1;
            rotacao_direita(x.pai);
            s = x.pai.esquerda;
          }
  
          if (s.direita.cor == 0 && s.direita.cor == 0) {
            s.cor = 1;
            x = x.pai;
          } else {
            if (s.esquerda.cor == 0) {
              s.direita.cor = 0;
              s.cor = 1;
              rotacao_esquerda(s);
              s = x.pai.esquerda;
            }
  
            s.cor = x.pai.cor;
            x.pai.cor = 0;
            s.esquerda.cor = 0;
            rotacao_direita(x.pai);
            x = raiz;
          }
        }
      }
      x.cor = 0;
    }
    //Reposiciona nós para rebalanceamento
    private void Repositorio_RedBlack(No u, No v) {
      if (u.pai == null) {
        raiz = v;
      } else if (u == u.pai.esquerda) {
        u.pai.esquerda = v;
      } else {
        u.pai.direita = v;
      }
      v.pai = u.pai;
    }
  
    private void deleteNo_aux(No no, int chave) {
      No z = TNULL;
      No x, y;
      while (no != TNULL) {
        if (no.info == chave) {
          z = no;
        }
  
        if (no.info <= chave) {
          no = no.direita;
        } else {
          no = no.esquerda;
        }
      }

      if (z == TNULL) {
        System.out.println("chave não encontrada");
        return;
      }
  
      y = z;
      int cor1_y = y.cor;
      if (z.esquerda == TNULL) {
        x = z.direita;
        Repositorio_RedBlack(z, z.direita);
      } else if (z.direita == TNULL) {
        x = z.esquerda;
        Repositorio_RedBlack(z, z.esquerda);
      } else {
        y = minimo(z.direita);
        cor1_y = y.cor;
        x = y.direita;
        if (y.pai == z) {
          x.pai = y;
        } else {
          Repositorio_RedBlack(y, y.direita);
          y.direita = z.direita;
          y.direita.pai = y;
        }
  
        Repositorio_RedBlack(z, y);
        y.esquerda = z.esquerda;
        y.esquerda.pai = y;
        y.cor = z.cor;
      }
      if (cor1_y == 0) {
        fixDelete(x);
      }
    }
  
    // Balanceia o Nó após inserção
    private void fixInsercao(No k) {
      No u;
      while (k.pai.cor == 1) {
        if (k.pai == k.pai.pai.direita) {
          u = k.pai.pai.esquerda;
          if (u.cor == 1) {
            u.cor = 0;
            k.pai.cor = 0;
            k.pai.pai.cor = 1;
            k = k.pai.pai;
          } else {
            if (k == k.pai.esquerda) {
              k = k.pai;
              rotacao_direita(k);
            }
            k.pai.cor = 0;
            k.pai.pai.cor = 1;
            rotacao_esquerda(k.pai.pai);
          }
        } else {
          u = k.pai.pai.direita;
  
          if (u.cor == 1) {
            u.cor = 0;
            k.pai.cor = 0;
            k.pai.pai.cor = 1;
            k = k.pai.pai;
          } else {
            if (k == k.pai.direita) {
              k = k.pai;
              rotacao_esquerda(k);
            }
            k.pai.cor = 0;
            k.pai.pai.cor = 1;
            rotacao_direita(k.pai.pai);
          }
        }
        if (k == raiz) {
          break;
        }
      }
      raiz.cor = 0;
    }
  
    private void imprime_aux(No raiz, String indentacao, boolean ultimo) {
      if (raiz != TNULL) {
        System.out.print(indentacao);
        if (ultimo) {
          System.out.print("Direita----");
          indentacao += "   ";
          tam++;
        } else {
          System.out.print("Esquerda----");
          indentacao += "|  ";
          tam++;
        }
  
        String scor = raiz.cor == 1 ? "Rubro" : "Negra";
        System.out.println(raiz.info + "(" + scor + ")");
        imprime_aux(raiz.esquerda, indentacao, false);
        imprime_aux(raiz.direita, indentacao, true);
      }
    }
  
    public Arvore_Rubro_Negra() {
      TNULL = new No();
      TNULL.cor = 0;
      TNULL.esquerda = null;
      TNULL.direita = null;
      raiz = TNULL;
    }
  
    public void pre_ordenacao() {
      ordena_1(this.raiz);
    }
  
    public void ordenacao() {
      Ordena_2(this.raiz);
    }
  
    public void posOrdenacao() {
      Ordenacao_final(this.raiz);
    }
  
    public No BuscaElem_arvore(int k) {
      return buscaChave(this.raiz, k);
    }
  
    public No minimo(No no) {
      while (no.esquerda != TNULL) {
        no = no.esquerda;
      }
      return no;
    }
  
    public No max(No no) {
      while (no.direita != TNULL) {
        no = no.direita;
      }
      return no;
    }
  
    public No proximo(No x) {
      if (x.direita != TNULL) {
        return minimo(x.direita);
      }
  
      No y = x.pai;
      while (y != TNULL && x == y.direita) {
        x = y;
        y = y.pai;
      }
      return y;
    }
  
    public No anterior(No x) {
      if (x.esquerda != TNULL) {
        return max(x.esquerda);
      }
  
      No y = x.pai;
      while (y != TNULL && x == y.esquerda) {
        x = y;
        y = y.pai;
      }
  
      return y;
    }
  
    public void rotacao_esquerda(No x) {
      No y = x.direita;
      x.direita = y.esquerda;
      if (y.esquerda != TNULL) {
        y.esquerda.pai = x;
      }
      y.pai = x.pai;
      if (x.pai == null) {
        this.raiz = y;
      } else if (x == x.pai.esquerda) {
        x.pai.esquerda = y;
      } else {
        x.pai.direita = y;
      }
      y.esquerda = x;
      x.pai = y;
    }
  
    public void rotacao_direita(No x) {
      No y = x.esquerda;
      x.esquerda = y.direita;
      if (y.direita != TNULL) {
        y.direita.pai = x;
      }
      y.pai = x.pai;
      if (x.pai == null) {
        this.raiz = y;
      } else if (x == x.pai.direita) {
        x.pai.direita = y;
      } else {
        x.pai.esquerda = y;
      }
      y.direita = x;
      x.pai = y;
    }
  
    public void Insere(int chave) {
        No no = new No();
        no.pai = null;
        no.info = chave;
        no.esquerda = TNULL;
        no.direita = TNULL;
        no.cor = 1;

        No y = null;
        No x = this.raiz;

        while (x != TNULL) {
          y = x;
          if (no.info < x.info) {
            x = x.esquerda;
          } else {
            x = x.direita;
          }
        }

        no.pai = y;
        if (y == null) {
          raiz = no;
        } else if (no.info < y.info) {
          y.esquerda = no;
        } else {
          y.direita = no;
        }

        if (no.pai == null) {
          no.cor = 0;
          return;
        }

        if (no.pai.pai == null) {
          return;
        }

        fixInsercao(no);
      }

      public No returnRaiz() {
          return this.raiz;
      }

      public void delete_No(int info) {
          deleteNo_aux(this.raiz, info);
          tam--;
      }

      public void Imprime_Arvore() {
          imprime_aux(this.raiz, "", true);
      }


}