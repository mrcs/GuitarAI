package dominio;

public class Acorde {
	private String nome;
	private boolean sustenido;
	private boolean bemol;
	private boolean setima;
	private boolean menor;
	private boolean maj;
	private String diagrama;
	
	public Acorde(String nome, boolean sustenido, boolean bemol, boolean setima, boolean menor, boolean maj, String diagrama) {
		this.nome = nome;
		this.sustenido = sustenido;
		this.bemol = bemol;
		this.setima = setima;
		this.menor = menor;
		this.maj = maj;
		this.diagrama = diagrama;
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

}
