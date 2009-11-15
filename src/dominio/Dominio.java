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
	
	public Dominio(){
		bd = new DominioBD();
	}

	public Erro erros(LinkedList<Questao> erradas) {
		return new Erro(erradas.iterator());	 
	}

	public Iterator<Questao> questoes(int nivel, Erro erros, int i) {
		/*
		 * provavelmente tem um erro aqui.
		 */
		int[] err = erros.getErros(2);
		float teste = erros.getProbabilidade(err[0]);
		int erro1 = (int) Math.floor(erros.getProbabilidade(err[0])*i);
		int erro2 = (int) Math.floor(erros.getProbabilidade(err[1])*i);
		//System.out.println(erros.getProbabilidade(err[0])+" "+erros.getProbabilidade(err[0])*i);
		
		
		LinkedList<Questao> questoes = new LinkedList<Questao>();
		Iterator<Questao> questoescomerro1;
		Iterator<Questao> questoescomerro2;
		
		int resto = i;
		
		if (erro1 != i) {
			
			questoescomerro1 = bd.questoes(nivel, getErro(err[0]), erro1);
			questoescomerro2 = bd.questoes(nivel, getErro(err[1]), erro2);
			while (questoescomerro2.hasNext()) {
				questoes.add(questoescomerro2.next());
				resto--;
			}
		} else {
			questoescomerro1 = bd.questoes(nivel, getErro(err[0]), erro1);
		}
		
		// resto vao ser questoes do mesmo nivel *note que erro1 = 0 *
		
						
		while (questoescomerro1.hasNext()) {
			questoes.add(questoescomerro1.next());
			resto--;
		}
		
		Iterator<Questao> questoescomnivel = bd.questoes(nivel, resto);
		
		while (questoescomnivel.hasNext())
			questoes.add(questoescomnivel.next());
		
		// isso foi sequencial, nao deveria.
		// pode ter questoes iguais, nao deveria.
		//System.out.println(questoes.size());
		
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
