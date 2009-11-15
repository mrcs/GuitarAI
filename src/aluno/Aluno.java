package aluno;

import java.util.Iterator;
import java.util.LinkedList;

import dominio.Dominio;
import dominio.Questao;

public class Aluno {

	// nível atual
	private int nivel;
	
	// nível objetivo
	private int objetivo;

	private LinkedList<Questao> erradas;
	private LinkedList<Questao> certas;
	
	public Aluno(int nivel, int objetivo) {
		this.nivel = nivel;
		this.objetivo = objetivo;
		erradas = new LinkedList<Questao>();
		certas = new LinkedList<Questao>();
	}
	
	public Aluno() {
		this.nivel = Dominio.INICIANTE;
		this.objetivo = Dominio.AVANCADO;
		erradas = new LinkedList<Questao>();
		certas = new LinkedList<Questao>();
	}
	
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

	public float getErroPorcentagem() {
		return (float) (getErradas().size())/(getErradas().size() + getCertas().size());
	}

	public float getErroPorcentagem(int nivel) {
		int erradas = 0;
		int certas 	= 0;
		
		Iterator<Questao> qErradas = getErradas().iterator();
		Iterator<Questao> qCertas  = getCertas().iterator();
		
		while (qErradas.hasNext()) 
			if (qErradas.next().getAcorde().getNivel() == nivel)
				erradas++;
		
		while (qCertas.hasNext())
			if (qCertas.next().getAcorde().getNivel() == nivel)
				certas++;
		
		//System.out.println((float)erradas/(erradas+certas));
		if ((certas == 0) && (erradas == 0))
			return 0;
		
		
		return (float) (erradas/(erradas+certas));
	}

}
