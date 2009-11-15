package dominio;

public class Acorde {
	private String nome;
	private boolean sustenido;
	private boolean bemol;
	private boolean setima;
	private boolean menor;
	private boolean maj;
	private String diagrama;
	private int nivel;
	
	public Acorde(String nome, boolean sustenido, boolean bemol, boolean setima, boolean menor, boolean maj, String diagrama, int nivel) {
		this.nome = nome;
		this.sustenido = sustenido;
		this.bemol = bemol;
		this.setima = setima;
		this.menor = menor;
		this.maj = maj;
		this.diagrama = diagrama;
		this.nivel = nivel;
	}
	
	public int getNivel() {
		return nivel;
	}

	public String getNome() {
		return nome;
	}
	public boolean isSustenido() {
		return sustenido;
	}
	public boolean isBemol() {
		return bemol;
	}
	public boolean isSetima() {
		return setima;
	}
	public boolean isMenor() {
		return menor;
	}

	public String getDiagrama() {
		return diagrama;
	}

	public boolean isMaj() {
		return maj;
	}

	public boolean isBasica() {
		return (!sustenido)&&(!bemol)&&(!setima)&&(!menor)&&(!maj);
	}

}
