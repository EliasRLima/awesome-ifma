package estruturas;

public class Aresta {
	private String idA;
	private String idB;
	private int tamanho;
	public Aresta(String idA, String idB, int tamanho) {
		super();
		this.idA = idA;
		this.idB = idB;
		this.tamanho = tamanho;
	}
	
	public String getIdA() {
		return idA;
	}
	public void setIdA(String idA) {
		this.idA = idA;
	}
	public String getIdB() {
		return idB;
	}
	public void setIdB(String idB) {
		this.idB = idB;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	
	
}
