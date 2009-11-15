package tutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

import aluno.*;
import dominio.*;

public class Tutor {
	
	// dominio
	private Dominio dominio;
	// aluno
	private Aluno aluno;
	
	// se ha proxima questao
	private boolean temQuestao;
	// se ha proxima licao
	private boolean temLicao;
	
	// flag para saber se ele acabou de mudar de nivel
	private boolean mudouNivel;
	/*
	 * ela fica true quando acabou de mudar de nivel
	 * ha perguntas
	 * quando vai iniciar uma licao ele verifica a quantidade de erros do aluno e seta ou nao essa variavel
	 * 
	 * entao: para essa variavel ser setada deve chamar um proximaLicao();
	 */
	
	
	// iterators das proximas licoes e questoes
	private Iterator<Questao> questoes;
	private Iterator<Questao> licoes;
	
	private final static float limiteErro = 0.3f;	// erradas/total > 0.3			aka 30%
	private final static int NUMERO_DE_QUESTOES = 5;

	public Tutor(Aluno aluno, Dominio dominio) {
		this.aluno = aluno;
		this.dominio = dominio;

		questoes = (new LinkedList<Questao>()).iterator();
		licoes = (new LinkedList<Questao>()).iterator();
		
		//	quando um tutor inicia, ele ensina primeiro
		this.temLicao 	= true;
		this.temQuestao = false;
		this.mudouNivel = true;	// faz sentido.
		
	}
	
	public boolean temQuestao() {
		return temQuestao;
	}
	
	public boolean temLicao() {
		return temLicao;
	}
	
	public Questao proximaQuestao() {
		
		if (!temQuestao)	
			return null;	// yes, we can.
		
		if (!questoes.hasNext()) {
			/*
			 * ok, se nao tem questoes precisa criar novas
			 * 	- se o aluno acabou de mudar de nivel: questoes desse nivel 
			 * 	- se o aluno esta refazendo questoes: questoes desse nivel com mais daquelas do erro
			 */
			int nivel = aluno.getNivel();
			if (mudouNivel) { 
				questoes = dominio.questoes(nivel, NUMERO_DE_QUESTOES);
				mudouNivel = false;
			} else
				questoes = dominio.questoes(nivel, dominio.erros(aluno.getErradas()), NUMERO_DE_QUESTOES);
		}	
		
		Questao questao = questoes.next();
		temQuestao = questoes.hasNext();
		temLicao = !temQuestao;
		
		return questao;
	}
	
	public Questao proximaLicao() {
		
		
		if (!temLicao)
			return null;	// yes, we can again.
		
		if (!licoes.hasNext()) {	
			/* se nao tem licoes, eh necessario novas 
			 * aqui entra inteligencia: quais licoes colocar utilizando os dados do aluno
			 * 	- nao ha questoes respondidas: novas questoes do nivel do aluno
			 * 	- ha questoes respondidas e um numero menor que K de erradas:	- novas questoes do proximo nivel
			 * 																	- nivel do aluno muda
			 * 	- ha questoes repondidas e um numero maior que K de erradas:	- repete o nivel colocando mais questoes dos tipos de erro
			 * 
			 * 
			 * ## UNICA PARTE QUE MUDA O NIVEL DO ALUNO EH AQUI (ISTO EH, ANTES DA LICAO!) ##
			*/
			
			int nivel = aluno.getNivel();
			if (!(aluno.getErradas().isEmpty() && aluno.getCertas().isEmpty())) {
				if (aluno.getErroPorcentagem(aluno.getNivel()) > limiteErro)	// errou mais que devia
					licoes = dominio.questoes(nivel, dominio.erros(aluno.getErradas()), NUMERO_DE_QUESTOES);
				else {										// errou ate o nivel maximo
					aluno.setNivel(nivel + 1);	// teste aqui para maior nivel possivel (fica onde? ou fica para proxima)
					this.mudouNivel = true; 	// acabou de mudar de nivel
					licoes = dominio.questoes(aluno.getNivel(), dominio.erros(aluno.getErradas()), NUMERO_DE_QUESTOES);
//					System.out.println("mudou de nivel!");
				}		
			} else	// entao nao ha questoes respondidas
				licoes = dominio.questoes(nivel, NUMERO_DE_QUESTOES);

		}
		
		Questao licao = licoes.next();
		temLicao = licoes.hasNext();
		temQuestao = !temLicao;
		
		return licao;
	}
	
	public boolean responde(Questao questao, String resposta) {
		boolean acertou = dominio.checaResposta(questao, resposta);
		
		if (acertou)
			aluno.acertou(questao);
		else
			aluno.errou(questao);
		
		return acertou;
	}

	public String getErros() {
		return getErros(3);			// #constante
	}
	
	public String getErros(int i) {
		// aparece o erro no estilo:
		// erro1, erro2, erro3.
		Erro erros = dominio.erros(aluno.getErradas());
		
		int[] tipos = erros.getErros(i);
		String resposta = " ";
		
		int a = 0;
		
		for (a = 0; a < i-1; a++) 
			resposta += dominio.getErro(tipos[a])+", ";
		
		resposta += dominio.getErro(tipos[a])+".";
		
		return resposta;
	}

	/*
		All that I feel is honor and spite
		All I can do is to set it right
	*/
	
	public String getMsg() {
		// nao sei o que colocar aqui.
		return null;
	}
	
	public static void main(String[] args) {
		Tutor tutor = new Tutor(new Aluno(),new Dominio());
		BufferedReader	inReader;
		inReader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			while (true) {
				System.out.println("Ensinando:");
				while(tutor.temLicao)
					System.out.println(tutor.proximaLicao().getAcorde().getNome());
				System.out.println("Questao:");
				while(tutor.temQuestao) {
					Questao atual = tutor.proximaQuestao();
					System.out.println(atual.getAcorde().getNome());
					line = inReader.readLine();
					System.out.println("respondeu: "+line);
					tutor.responde(atual, line);
				}
				System.out.println("Errou muito "+tutor.getErros(1));
			
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			inReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		try {
			while(()!= null) {
				soma += Integer.parseInt(line);
			}
			System.out.println(soma);
			inReader.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} */

        
/*		while(tutor.temLicao)
			System.out.println(tutor.proximaLicao().getAcorde().getNome());
		
		while(tutor.temQuestao) {
			System.out.println(tutor.proximaQuestao().getAcorde().getNome());
			
			*/
		

	}

	//public void mudaNivel()
}
