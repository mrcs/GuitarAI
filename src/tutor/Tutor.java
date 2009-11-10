package tutor;

import java.util.Iterator;

import aluno.*;
import dominio.*;

public class Tutor {
/*
 * O tutor tem o aluno e o dominio
 * 
 * a estratégia de ensino é a conexão entre
 * o aluno e o dominio
 * ela busca as questões em dominio a partir do
 * nível e dificuldade do aluno
 * 
 * o tutor também diz onde o aluno está errando mais 
 * e onde ele deve melhorar
 * 
 * a partir dessa informação ele fornece mais aulas
 * de um determinado assunto
 */
	
	// domínio
	private Dominio dominio;
	// aluno
	private Aluno aluno;
	
	// se há proxima questao
	private boolean temQuestao;
	// se há proxima licao
	private boolean temLicao;
	
	// iterators das proximas lições e questões
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
