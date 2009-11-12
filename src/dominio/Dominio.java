package dominio;

import java.util.Iterator;
import java.util.LinkedList;

public class Dominio {
	
	public static final int INICIANTE = 0;
	public static final int INTERMEDIARIO = 1;
	public static final int AVANCADO = 2;
	
	public DominioBD bd;

	public Iterator<Erro> erros(LinkedList<Questao> erradas) {
		// note que iterator eh desnecessario
		LinkedList<Erro> lista = new LinkedList<Erro>();
		lista.add(new Erro((Iterator<Questao>) erradas));
		
		// um dia pode ser; as you may know xp is ftf

		return lista.iterator();	 
	}

	public Iterator<Questao> questoes(int nivel, Iterator<Erro> erros, int i) {
		return bd.questoes(nivel, i, i); 	// i questoes desse nivel com esses erros (pode ser apenas um ou nehum)
	}

	public Iterator<Questao> questoes(int nivel, int i) {
		return bd.questoes(nivel, i); 			// i questoes desse nivel
	}

	public boolean checaResposta(Questao questao, String resposta) {
		return questao.resposta(resposta);
	}

	public Iterator<Licao> licoes(int nivel, int i) {
		return bd.licoes(nivel,i);				// i licoes desse nivel
	}

	public Iterator<Licao> licoes(int nivel, Iterator<Erro> erros, int i) {
		return bd.licoes(nivel,i,i);		// i licoes desse nivel e que aborde esses erros
												// erros pode ta vazio, isto eh, pode ser apenas desse nivel
	}
}
