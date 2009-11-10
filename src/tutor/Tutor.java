package tutor;

import java.util.Iterator;

import aluno.*;
import dominio.*;

public class Tutor {
/*
 * O tutor tem o aluno e o dominio
 * 
 * a estrat�gia de ensino � a conex�o entre
 * o aluno e o dominio
 * ela busca as quest�es em dominio a partir do
 * n�vel e dificuldade do aluno
 * 
 * o tutor tamb�m diz onde o aluno est� errando mais 
 * e onde ele deve melhorar
 * 
 * a partir dessa informa��o ele fornece mais aulas
 * de um determinado assunto
 */
	
	// dom�nio
	private Dominio dominio;
	// aluno
	private Aluno aluno;
	
	// se h� proxima questao
	private boolean temQuestao;
	// se h� proxima licao
	private boolean temLicao;
	
	// iterators das proximas li��es e quest�es
	private Iterator<Questao> questoes;
	private Iterator<Licao> licoes;

	public Tutor(Aluno aluno, Dominio dominio) {
		this.aluno = aluno;
		this.dominio = dominio;

		//	quando um tutor inicia, ele ensina primeiro
		this.temLicao = true;
		this.temQuestao = false;
	}
	
	boolean temQuestao() {
		return temLicao;
	}
	
	public boolean temLicao() {
		return temQuestao;
	}
	
	public Questao proximaQuestao() {
		
		if (!temQuestao)	
			return null;	// yes, we can.
		
		if (!questoes.hasNext()) {
			/*
			 * nivel do aluno = aluno.nivel;
			 * tipo de erros = aluno.tipodeerros
			 * questoes = dominio.questoes(nivel aluno, tipo)
			 */
			questoes = dominio.questoes();
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
	
}
