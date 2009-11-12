package dominio;

import java.util.Iterator;
import java.util.LinkedList;

public class Dominio {
	
	public static final int INICIANTE = 0;
	public static final int INTERMEDIARIO = 1;
	public static final int AVANCADO = 2;
	
	private final static int BASICA 	= 0; 
	private final static int SETIMA		= 1;
	private final static int SUSTENIDO	= 2;
	private final static int BEMOL		= 3;
	private final static int MAJ		= 5;
	private final static int MENOR		= 6;
	
	public DominioBD bd;

	@SuppressWarnings("unchecked")
	public Erro erros(LinkedList<Questao> erradas) {
			return new Erro((Iterator<Questao>) erradas);	 
	}

	public Iterator<Questao> questoes(int nivel, Erro erros, int i) {
		/*
		 * em erros vou pegar os N erros mais frequentes
		 * utilizando o bd vou pegar
		 * 
		 * (erros[tipo].quantidade / i)
		 *  
		 *  
		 */
		// isso deve estar errado, estou com sono
		int[] err = erros.getErros(2);
		int erro1 = (int) Math.floor(erros.getProbabilidade(err[0])*i);
		int erro2 = (int) Math.floor(erros.getProbabilidade(err[1])*i);
		int resto = i - erro1 - erro2;	//esses vão ser do mesmo nivel
		Iterator<Questao> questoescomerro1 = bd.questoes(nivel, getErro(err[0]), erro1);
		Iterator<Questao> questoescomerro2 = bd.questoes(nivel, getErro(err[1]), erro2);
		Iterator<Questao> questoescomnivel = bd.questoes(nivel, resto);
		
		LinkedList<Questao> questoes = new LinkedList<Questao>();
		
		while (questoescomerro1.hasNext())
			questoes.add(questoescomerro1.next());
		
		while (questoescomerro2.hasNext())
			questoes.add(questoescomerro2.next());
		
		while (questoescomnivel.hasNext())
			questoes.add(questoescomnivel.next());
		
		// isso foi sequencial, nao deveria.
		// pode ter questoes iguais, nao deveria.
		
		return questoes.iterator();
	}

	public Iterator<Questao> questoes(int nivel, int i) {
		return bd.questoes(nivel, i); 	
	}

	public boolean checaResposta(Questao questao, String resposta) {
		return questao.resposta(resposta);
	}

	public String getErro(int i) {
		String resposta = "";
		switch (i) {
		case BASICA:
			resposta = "basica"; 
			break;
		case SETIMA:
			resposta = "setima";
			break;
		case SUSTENIDO:
			resposta = "sustenido";
			break;
		case BEMOL:
			resposta = "bemol";
			break;
		case MAJ:
			resposta = "maj";
			break;
		case MENOR:
			resposta = "menor";
			break;
		}
		return resposta;
	}
}
