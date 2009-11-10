package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

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
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<Licao> licoes(int nivel, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<Licao> licoes(int nivel, Iterator<Erro> erros, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/* essa classe eh a conexao com o banco de dados
	 * eh mais facil fazer select por aqui
	 * e eh o que buarque gostaria.
	 */
	
}
