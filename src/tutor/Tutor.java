package tutor;

import java.util.Iterator;

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
	
	// iterators das proximas licoes e questoes
	private Iterator<Questao> questoes;
	private Iterator<Licao> licoes;

	public Tutor(Aluno aluno, Dominio dominio) {
		this.aluno = aluno;
		this.dominio = dominio;

		//	quando um tutor inicia, ele ensina primeiro
		this.temLicao = true;
		this.temQuestao = false;
	}
	
	public boolean temQuestao() {
		return temLicao;
	}
	
	public boolean temLicao() {
		return temQuestao;
	}
	
	public Questao proximaQuestao() {
		
		if (!temQuestao)	
			return null;	// yes, we can.
		
		if (!questoes.hasNext()) {
			int nivel = aluno.getNivel();
			if (!(aluno.getErradas().isEmpty() && aluno.getCertas().isEmpty())) {
				Iterator<Erro> erros = dominio.erros(aluno.getErradas()); 
				questoes = dominio.questoes(nivel, erros, 5);
				// cinco questoes com nivel e sobre os erros
			} else
				questoes = dominio.questoes(nivel, 5);
				// cinco questoes com nivel 
		}	
		return questoes.next();
	}
	
	public Licao proximaLicao() {
		
		if (!temLicao)
			return null;	// yes, we can again.
		
		if (!licoes.hasNext()) {
			//similar ao de cima
			licoes = dominio.licoes();
		}
		
		return licoes.next();
	}
	
	public boolean responde(Questao questao, String resposta) {
		boolean acertou = dominio.checaResposta(questao, resposta);
		
		if (acertou)
			aluno.acertou(questao);
		else
			aluno.errou(questao);
		
		return acertou;
	}
	
	//public void mudaNivel()
}
