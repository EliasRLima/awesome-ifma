package com.mycompany.arvore_b;


public class Arvore_B {

  private int T;

  // Implementação No
    public class No {
        int n;
        int chave[] = new int[2 * T - 1];
        No filho[] = new No[2 * T];
        boolean folha = true;

        public int Contem(int k) {
          for (int i = 0; i < this.n; i++) {
            if (this.chave[i] == k) {
              return i;
            }
          }
          return -1; //NULL
        };
    }

  public Arvore_B(int t) {
    T = t;
    raiz = new No();
    raiz.n = 0;
    raiz.folha = true;
  }
  
  private No raiz;

  // Busca chave
  private No Busca(No x, int chave) {
    int i = 0;
    if (x == null)
      return x;
    for (i = 0; i < x.n; i++) {
      if (chave < x.chave[i]) {
        break;
      }
      if (chave == x.chave[i]) {
        return x;
      }
    }
    if (x.folha) {
      return null;
    } else {
      return Busca(x.filho[i], chave);
    }
  }

  // Dividindo o No
  private void Divide(No x, int pos, No y) {
    No z = new No();
    z.folha = y.folha;
    z.n = T - 1;
    for (int j = 0; j < T - 1; j++) {
      z.chave[j] = y.chave[j + T];
    }
    if (!y.folha) {
      for (int j = 0; j < T; j++) {
        z.filho[j] = y.filho[j + T];
      }
    }
    y.n = T - 1;
    for (int j = x.n; j >= pos + 1; j--) {
      x.filho[j + 1] = x.filho[j];
    }
    x.filho[pos + 1] = z;

    for (int j = x.n - 1; j >= pos; j--) {
      x.chave[j + 1] = x.chave[j];
    }
    x.chave[pos] = y.chave[T - 1];
    x.n = x.n + 1;
  }

  // Insere valor - Código do Produto - 
  public void Insere(final int chave) {
    No r = raiz;
    if (r.n == 2 * T - 1) {
      No s = new No();
      raiz = s;
      s.folha = false;
      s.n = 0;
      s.filho[0] = r;
      Divide(s, 0, r);
      Insere_valor(s, chave);
    } else {
      Insere_valor(r, chave);
    }
  }

  // Insere  No
  final private void Insere_valor(No x, int k) {

    if (x.folha) {
      int i = 0;
      for (i = x.n - 1; i >= 0 && k < x.chave[i]; i--) {
        x.chave[i + 1] = x.chave[i];
      }
      x.chave[i + 1] = k;
      x.n = x.n + 1;
    } else {
      int i = 0;
      for (i = x.n - 1; i >= 0 && k < x.chave[i]; i--) {
      }
      ;
      i++;
      No tmp = x.filho[i];
      if (tmp.n == 2 * T - 1) {
        Divide(x, i, tmp);
        if (k > x.chave[i]) {
          i++;
        }
      }
      Insere_valor(x.filho[i], k);
    }

  }

  public void Imprime() {
    Imprime(raiz);
  }

  // Imprime interface
  private void Imprime(No x) {
    assert (x == null);
    for (int i = 0; i < x.n; i++) {
      System.out.print(x.chave[i] + " ");
    }
    if (!x.folha) {
      for (int i = 0; i < x.n + 1; i++) {
        Imprime(x.filho[i]);
      }
    }
  }

  // Checagem se possui o valor
  public boolean Possui(int k) {
    if (this.Busca(raiz, k) != null) {
      return true;
    } else {
      return false;
    }
  }

}