package tutor;

import dominio.Licao;

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
