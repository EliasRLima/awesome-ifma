package Questao_5;

/**
 *
 * @author artur
 */
import java.util.LinkedList;
import java.util.List;

public class Vertices {

  public String nome;
  public int x;
  public int y;
  public boolean percorre;
  public double distancia; // distancia total do ponto de Origem
  public Vertices prev;
  public List<Arestas> ArestaAdj;

  public Vertices(String nome, int x, int y) {
    this.nome = nome;
    this.x = x;
    this.y = y;

    ArestaAdj = new LinkedList<Arestas>();
    prev = null;
  }

  @Override
  public int hashCode() {
    //Definição função Hash em HashMap, assim parte do ponto de vista que cada vertice tem um nome único
    return nome.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (!(o instanceof Vertices)) {
      return false;
    }
    Vertices oVertice = (Vertices) o;

    return nome.equals(oVertice.nome) && x == oVertice.x && y == oVertice.y;
  }

  public void AdicionaAresta(Arestas edge) {
    ArestaAdj.add(edge);
  }

  public String toString() {
    return nome + " (Km " + x + ",Km " + y + ")";
  }
}
