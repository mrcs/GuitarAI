package dominio;

import java.util.Iterator;
import java.util.LinkedList;

public class Dominio {
	
	public static final int INICIANTE = 0;
	public static final int INTERMEDIARIO = 1;
	public static final int AVANCADO = 2;
	
	public Iterator<Questao> questoes() {
		// TODO Auto-generated method stub
		return null;
	}
/*
 * Dominio inicialmente carregar atraves do txt 
 * 
 * Vai ter 5 matrizes de níveis
 * 
 * Há questoes e licoes aqui
 * 
 * Deve haver um método que retorna questões/aula
 * a partir de um nível e um assunto 
 * 
 */

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
}
