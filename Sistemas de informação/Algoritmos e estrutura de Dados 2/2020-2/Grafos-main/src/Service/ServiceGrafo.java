package Service;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import estruturas.Aresta;
import estruturas.Percurso;

public class ServiceGrafo {
	ArrayList<Aresta> arestas;

	public ServiceGrafo(String link) throws FileNotFoundException {
		carregaArquivo(link);
	}



	private void carregaArquivo(String link) throws FileNotFoundException {
		arestas = new ArrayList<Aresta>();
		Scanner in = new Scanner(new FileReader(link));
		while (in.hasNextLine()) {
			String aux[] = in.nextLine().toString().split(";");
			arestas.add(new Aresta(aux[0], aux[1], Integer.parseInt(aux[2])));
		}
	}
	
	public void list() {
		for(Aresta a : arestas) {
			System.out.println(a.getIdA() + " e " + a.getIdB() + " com valor " + a.getTamanho() + "km.");
		}
	}
	
	public void listLargura() {
		ArrayList<String> listados = new ArrayList<String>();
		for(Aresta a : arestas) {
			if(!listados.contains(a.getIdA())) {
				Largura(a.getIdA(), listados);
				listados.add(a.getIdA());
			}
			if(!listados.contains(a.getIdB())){
				Largura(a.getIdB(),listados);
				listados.add(a.getIdB());
			}
			
		}
	}
	
	private void Largura(String id, ArrayList<String> exc) {
		for(Aresta a : arestas) {
			if(a.getIdA().equals(id) && !exc.contains(a.getIdB()))
				System.out.println(a.getIdA() + " e " + a.getIdB() + " com valor " + a.getTamanho() + "km.");
			if(a.getIdB().equals(id) && !exc.contains(a.getIdA()))
				System.out.println(a.getIdB() + " e " + a.getIdA() + " com valor " + a.getTamanho() + "km.");
		}
	}
	
	public void listProfundidade() {
		ArrayList<String> listados = new ArrayList<String>();
		for(Aresta a : Reversed.reversed(arestas)) {
			if(!listados.contains(a.getIdB())){
				Profundidade(a.getIdB(),listados);
				listados.add(a.getIdB());
			}
			if(!listados.contains(a.getIdA())) {
				Profundidade(a.getIdA(), listados);
				listados.add(a.getIdA());
			}
		}
	}
	
	private void Profundidade(String id, ArrayList<String> exc) {
		for(Aresta a : Reversed.reversed(arestas)) {
			if(a.getIdA().equals(id) && !exc.contains(a.getIdB()))
				System.out.println(a.getIdA() + " e " + a.getIdB() + " com valor " + a.getTamanho() + "km.");
			if(a.getIdB().equals(id) && !exc.contains(a.getIdA()))
				System.out.println(a.getIdB() + " e " + a.getIdA() + " com valor " + a.getTamanho() + "km.");
		}
	}
	
	public boolean isBipartido() {
		ArrayList<String> conjuntoU = new ArrayList<String>();
		ArrayList<String> conjuntoV = new ArrayList<String>();
		
		for(Aresta a : arestas) {
			if(conjuntoU.contains(a.getIdA())) {
				if(conjuntoU.contains(a.getIdB())) {
					return false; //elementos do msm conjunto ligados
				}else if(conjuntoV.contains(a.getIdB())){
					continue; //elementos de conjuntos distintos
				}else {
					conjuntoV.add(a.getIdB()); //adicionar no conjunto oposto
				}
			}else if(conjuntoV.contains(a.getIdA())){
				if(conjuntoU.contains(a.getIdB())) {
					continue; //elementos de conjuntos distintos
				}else if(conjuntoV.contains(a.getIdB())){
					return false; //elementos do msm conjunto ligados
				}else {
					conjuntoU.add(a.getIdB()); //adicionar no conjunto oposto
				}
			}else {
				if(conjuntoU.contains(a.getIdB())) {
					 conjuntoV.add(a.getIdA());
				}else if(conjuntoV.contains(a.getIdB())){
					conjuntoU.add(a.getIdA());
					
				}else {
					conjuntoU.add(a.getIdA());
					conjuntoV.add(a.getIdB());
				}
			}
		}
		return true;
	}
	
	private int numConexoes(String id) {
		int num = 0;
		for(Aresta a : arestas) {
			if(a.getIdA().equals(id))
				num++;
			if(a.getIdB().equals(id))
				num++;
		}
		return num;
	}
	
	private ArrayList<String> getIdsConectados(String id){
		ArrayList<String> ids = new ArrayList<String>();
		for(Aresta a : arestas) {
			if(a.getIdA().equals(id)) {
				if(!ids.contains(a.getIdB()))
					ids.add(a.getIdB());
				continue;
			}
				
			if(a.getIdB().equals(id)) {
				if(!ids.contains(a.getIdA()))
					ids.add(a.getIdA());
			}
		}
		return ids;
	}
	
	private boolean existeConexao(String idA, String idB) {
		for(Aresta a : arestas) {
			if(a.getIdA().equals(idA) && a.getIdB().equals(idB))
				return true;
			if(a.getIdA().equals(idB) && a.getIdB().equals(idA))
				return true;
		}
		return false;
	}
	
	public void menorDistancia(String idA, String idB) {
		int conexoesDestino = numConexoes(idB);
		if(numConexoes(idB) == 0) {
			System.out.println("Esse elemento nao esta presente em nenhuma conexao!");
		}
		
		Percurso p = new Percurso();
		ArrayList<Percurso> possiveis = new ArrayList<Percurso>();
		
		_menorDistancia(p,idA, idB, possiveis);
		
		int menor = -1;
		Percurso mp = new Percurso();
		for(Percurso ps : possiveis) {
			if(menor == -1 || ps.getCusto() < mp.getCusto())
				mp = ps;
		}
		System.out.println("Menor caminho de "+idA+" ate "+idB+" :");
		mp.list();
	}
	
	public Aresta getAresta(String idA, String idB) {
		for(Aresta a : arestas) {
			if((a.getIdA().equals(idA) && a.getIdB().equals(idB)) || (a.getIdB().equals(idA) && a.getIdA().equals(idB)))
				return new Aresta(idA, idB, a.getTamanho());
		}
		return new Aresta(idA, idB, 0);
	}
	
	private Percurso _menorDistancia(Percurso p,String partida, String destino, ArrayList<Percurso> possiveis) {
		if(p == null) {
			p = new Percurso();
		}
		int conexoes = numConexoes(partida);
		if(partida.equals(destino)) {
			return p;
		}
		if(conexoes == 0) {
		}else {
			Percurso aux, menor_percurso = new Percurso();
			
			int menor = -1; 
			for(String a : getIdsConectados(partida)) {
				ArrayList<String> conectados = getIdsConectados(partida);
				int ver = 0;
				for(String g : conectados) {
					if(!p.jaPassou(g))
						ver++;
				}
				if(ver == 0) {
					continue;
				}
				if(p.jaPassou(a))
					continue;
				aux = new Percurso();
				for(Aresta ars : p.getArestas()) {
					aux.addNaArestas(ars);
				}
				aux.addNaArestas(getAresta(partida, a));
				_menorDistancia(aux,a, destino,possiveis);
				if(aux.getUltima().getIdB().equals(destino)) {
					menor = aux.getCusto();
					for(Aresta aa : aux.getArestas()) {
						menor_percurso.addNaArestas(aa);
					}
					possiveis.add(menor_percurso);
				}else {
				}
			}
			return menor_percurso;
			
		}
		return p;
	}
	
}
