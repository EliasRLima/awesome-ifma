package estruturas;

import java.util.ArrayList;

import Service.Reversed;

public class Percurso {
	ArrayList<Aresta> arestas;
	int custo = 0;
	
	public Percurso() {
		// TODO Auto-generated constructor stub
		arestas = new ArrayList<Aresta>();
	}
	
	public Percurso(ArrayList<Aresta> arr) {
		// TODO Auto-generated constructor stub
		arestas = arr;
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public void addNaArestas(Aresta aresta) {
		this.arestas.add(aresta);
		this.custo += aresta.getTamanho();
	}

	public int getCusto() {
		return custo;
	}

	public void addCusto(int custo) {
		this.custo += custo;
	}
	
	public boolean jaPassou(String id) {
		for(Aresta a : arestas) {
			if(a.getIdA().equals(id) || a.getIdB().equals(id))
				return true;
		}
		return false;
	}
	
	public Aresta getUltima() {
		for(Aresta a : Reversed.reversed(arestas)) {
			return a;
		}
		return null;
	}
	
	public void list() {
		System.out.println("");
		for(Aresta a : arestas) {
			System.out.println(a.getIdA() + " -> " + a.getIdB());
		}
		System.out.println("\n*total de "+this.custo+"km de distancia.");
	}
	
}
