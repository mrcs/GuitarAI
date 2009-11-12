package dominio;


public class Questao {
	private Acorde acorde;

	public Questao(Acorde acorde) {
		this.acorde = acorde;
		
	}

	public boolean resposta(String resposta) {
		return acorde.getNome().equals(resposta);
	}

	public Acorde getAcorde() {
		return acorde;
	}
}
