package tutor;

import dominio.Licao;

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
	private boolean questao;
	
	private boolean licao;
	
	boolean temQuestao() {
		return licao;
	}
	
	public boolean temLicao() {
		return questao;
	}
	
	public Questao proximaQuestao() {
		
	}
	
	public Licao proximaLicao() {
		
	}
	
}
