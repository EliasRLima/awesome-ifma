package Questao_5;

/**
 *
 * @author artur
 */
public class Arestas {

  public double distancia;
  public Vertices fonte;
  public Vertices fim;

  public Arestas(Vertices vertice_1, Vertices vertice_2, double peso) {
    fonte = vertice_1;
    fim = vertice_2;
    this.distancia = peso;
  }

  public String toString() {
    return fonte + " -> " + fim;
  }
}