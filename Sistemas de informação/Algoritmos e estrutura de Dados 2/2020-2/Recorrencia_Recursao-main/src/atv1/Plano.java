package atv1;

import java.util.ArrayList;

public class Plano {
	
	private ArrayList<Ponto> pontos;

	public Plano(ArrayList<Ponto> pontos) {
		super();
		this.pontos = pontos;
	}
	
	public void addPonto(Ponto a) {
		pontos.add(a);
	}
	
	public void removePonto(int index) {
		pontos.remove(index);
	}
	
	public void listTodasDistancias() {
		if(pontos.size() < 2) {
			System.out.println("Numero insulficiente de pontos no plano.");
			return;
		}
		
		for(int i = 0; i < pontos.size(); i++) {
			System.out.println("Distancias referente ao ponto " + pontos.get(i).getIdentificador() + ":");
			
			for(int j = 0; j < pontos.size(); j++) {
				if(j == i)
					continue;
				double d = distancia(pontos.get(i), pontos.get(j));
				
				System.out.println("A distancia entre o ponto " + pontos.get(i).getIdentificador() + " e " + pontos.get(j).getIdentificador() + " foi de " + d + ".");
			}
		}
	}
	
	public void listMenorDistancia() {
		if(pontos.size() < 2) {
			System.out.println("Numero insulficiente de pontos no plano.");
			return;
		}
		
		double menor = -1;
		Ponto M1 = pontos.get(0);
		Ponto M2 = pontos.get(1);
		
		for(int i = 0; i < pontos.size(); i++) {
			for(int j = 0; j < pontos.size(); j++) {
				if(j == i)
					continue;
				double d = distancia(pontos.get(i), pontos.get(j));
				
				if(menor == -1 || menor > d) {
					M1 = pontos.get(i);
					M2 = pontos.get(j);
					menor = d;
				}
			}
		}
		
		System.out.println("A menor distancia foi entre o ponto " + M1.getIdentificador() + " e " + M2.getIdentificador() + " tendo a distancia de " + menor + ".");
	}
	
	private double distancia(Ponto a, Ponto b) {
		double x = ((a.getX()*a.getX()) - (2*(a.getX() * b.getX())) + (b.getX()*b.getX()));
		double y = (a.getY()*a.getY()) - (2*(a.getY() * b.getY())) + (b.getY() * b.getY());
		
		double distancia = Math.sqrt(x + y);
		
		return distancia;
	}
}
