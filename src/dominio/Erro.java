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
	private int total;
	
	public Erro(Iterator<Questao> erradas) {
		
		erro = new int[7];
		total = 0;
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
			if (questao.getAcorde().isBasica());
				erro[DIFICULDADE_COM_BASICAS]++;
			total++;
		}
	}
	

	public int[] getErros(int i) {
		int[] retErros = new int[i];
		
		int[] erro = this.erro.clone();
		
		for (int k = 0; k < i; k++) {
			int j = 0;
			int maior = 0;
			for (j = 0; j < erro.length; j++) 
				if (erro[j] > erro[maior]) 
					maior = j;
			retErros[k] = maior;
			erro[maior] = 0;
		}

		return retErros;
	}


	public float getProbabilidade(int i) {
		
		if (total == 0)
			return total;
		//System.out.println(erro[i]);
		//System.out.println(total);
		return (erro[i]/total);
	}

}
