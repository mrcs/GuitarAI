package dominio;

import java.util.Iterator;
import java.util.LinkedList;

public class Dominio {
	
	public static final int INICIANTE = 0;
	public static final int INTERMEDIARIO = 1;
	public static final int AVANCADO = 2;
	
	public DominioBD bd;
	
	public Iterator<Questao> questoes() {
		// TODO Auto-generated method stub
		return null;
	}
	public Iterator<Licao> licoes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<Erro> erros(LinkedList<Questao> erradas) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<Questao> questoes(int nivel, Iterator<Erro> erros, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<Questao> questoes(int nivel, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checaResposta(Questao questao, String resposta) {
		return questao.resposta(resposta);
	}

	public Iterator<Licao> licoes(int nivel, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<Licao> licoes(int nivel, Iterator<Erro> erros, int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
