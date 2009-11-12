package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;

public class DominioBD {

	// sim, isso sera constante: 
	private static final String ip = "localhost";
	private static final String user = "root";
	private static final String senha = "";
	private static final String bd = "GuitarAI";

	// reuso a partir de ProjetoOnibus/dados/ConexaoBD
	private ResultSet query(String query) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip+ "/" + bd + "?user=" + user + "&password=" + senha);
		Statement stm = conn.createStatement();
		return stm.executeQuery(query);
	}

	private boolean execute(String query) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip	+ "/" + bd + "?user=" + user + "&password=" + senha);
		Statement stm = conn.createStatement();
		return stm.execute(query);
	}

	public Iterator<Questao> questoes(int nivel, Iterator<Erro> erros, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Iterator<Questao> questoes(int nivel, int i) {
		String nome;
		boolean sustenido;
		boolean bemol;
		boolean setima;
		boolean menor;
		boolean maj;
		String diagrama;
		Questao questao;
		Acorde acorde;
		LinkedList<Questao> lista = new LinkedList<Questao>();
		try {
			ResultSet resposta = query("SELECT * FROM `acorde` WHERE `nivel`="+nivel+" LIMIT 0 ,"+i);
			while(resposta.next()){
				nome = resposta.getString("nome");
				sustenido = resposta.getString("sustenido").equals(1);
				bemol = resposta.getString("bemol").equals(1);
				setima = resposta.getString("setima").equals(1);
				menor = resposta.getString("menor").equals(1);
				maj = resposta.getString("maj").equals(1);
				diagrama = resposta.getString("diagrama");
				acorde = new Acorde(nome,sustenido,bemol,setima,menor,maj,diagrama);
				questao = new Questao(acorde);
				lista.add(questao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				return lista.iterator();
	}
	public Iterator<Licao> licoes(int nivel, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<Licao> licoes(int nivel, Iterator<Erro> erros, int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
