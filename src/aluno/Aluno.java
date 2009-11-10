package aluno;

import java.util.LinkedList;

import dominio.Dominio;
import dominio.Questao;

public class Aluno {

	// nível atual
	private int nivel;
	
	// nível objetivo
	private int objetivo;
	
	public Aluno(int nivel, int objetivo) {
		this.nivel = nivel;
		this.objetivo = objetivo;
	}
	
	public Aluno() {
		this.nivel = Dominio.INICIANTE;
		this.objetivo = Dominio.AVANCADO;
	}
	
	private LinkedList<Questao> erradas;
	private LinkedList<Questao> certas;
	
	public void acertou(Questao questao) {
		erradas.remove(questao);
		certas.add(questao);
	}
	
	public void errou(Questao questao) {
		certas.remove(questao);
		erradas.add(questao);
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(int objetivo) {
		this.objetivo = objetivo;
	}

	public LinkedList<Questao> getErradas() {
		return erradas;
	}

	public LinkedList<Questao> getCertas() {
		return certas;
	}
	
}
