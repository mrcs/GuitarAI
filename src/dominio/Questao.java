package dominio;


public class Questao {
	public Acorde acorde;

	public boolean resposta(String resposta) {
		return acorde.getNome().equals(resposta);
	}
}
