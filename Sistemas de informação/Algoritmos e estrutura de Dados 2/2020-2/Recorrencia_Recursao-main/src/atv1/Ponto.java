package atv1;

public class Ponto {
	private int x = 0;
	private int y = 0;
	private String identificador;
	
	public Ponto(int x, int y, String identificador) {
		super();
		this.x = x;
		this.y = y;
		this.identificador = identificador;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	
	
	
	
}
