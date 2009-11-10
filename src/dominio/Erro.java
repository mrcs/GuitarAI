package dominio;

import java.util.Iterator;

public class Erro {
	
	// a classe Erro pode parecer desnecessaria.. mas pense direititinho
	// 																	todas sao.. (=
	
	private final static int DIFICULDADE_COM_BASICAS 	= 0; 
	private final static int DIFICULDADE_COM_SETIMAS	= 1;
	private final static int DIFICULDADE_COM_SUSTENIDO	= 2;
	private final static int DIFICULDADE_COM_BEMOL		= 3;
	private final static int DIFICULDADE_COM_MAJ		= 5;
	private final static int DIFICULDADE_COM_MENOR		= 6;
	
	private int erro[];
	
	public Erro(Iterator<Questao> erradas) {
		
		erro = new int[7];
		
		while (erradas.hasNext()) {
			Questao questao = erradas.next();
			if (questao.acorde.isBemol())
				erro[DIFICULDADE_COM_BEMOL]++;
			if (questao.acorde.isSetima())
				erro[DIFICULDADE_COM_SETIMAS]++;
			if (questao.acorde.isSustenido())
				erro[DIFICULDADE_COM_SUSTENIDO]++;
			if (questao.acorde.isMenor())
				erro[DIFICULDADE_COM_MENOR]++;
			if (questao.acorde.isMaj())
				erro[DIFICULDADE_COM_MAJ]++;
		}
	}
}
