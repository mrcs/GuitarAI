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
			if (questao.getAcorde().isBemol())
				erro[DIFICULDADE_COM_BEMOL]++;
			if (questao.getAcorde().isSetima())
				erro[DIFICULDADE_COM_SETIMAS]++;
			if (questao.getAcorde().isSustenido())
				erro[DIFICULDADE_COM_SUSTENIDO]++;
			if (questao.getAcorde().isMenor())
				erro[DIFICULDADE_COM_MENOR]++;
			if (questao.getAcorde().isMaj())
				erro[DIFICULDADE_COM_MAJ]++;
		}
	}
}
