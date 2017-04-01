import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {

	private static final String USUARIO = "";
	private static final String SENHA = "";
	private static final String URL = "";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	// Conectar ao banco
	private static Connection abrir() throws Exception {
		// Registrar o driver
		Class.forName(DRIVER);
		// Capturar a conexão
		Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
		// Retorna a conexao aberta
		return conn;

	}

	public static void atualizar(MatrizAdj graf) throws Exception {
		String sql = new String();
		sql = "SELECT *FROM vertices;";
		/* Abre a conexão que criamos o retorno é armazenado na variavel conn */
		Connection conn = Conexao.abrir();
		/* Mapeamento objeto relacional */
		PreparedStatement comando = conn.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery();
		while (resultado.next()) {
			graf.inserirVertice(resultado.getInt("peso"), resultado.getString("ruaHorizontal"),
					resultado.getString("ruaVertical"),resultado.getInt("id"));
		}
		sql = "SELECT origem , destino FROM arestas;";
		comando = conn.prepareStatement(sql);
		resultado = comando.executeQuery();
		while (resultado.next()) {
			graf.insereArestaSql(resultado.getInt("origem"), resultado.getInt("destino"));
		}
	}

	public static void atualizar(ListaAdj graf) throws Exception {
		String sql = new String();
		sql = "SELECT *FROM vertices;";
		/* Abre a conexão que criamos o retorno é armazenado na variavel conn */
		Connection conn = Conexao.abrir();
		/* Mapeamento objeto relacional */
		PreparedStatement comando = conn.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery();
		while (resultado.next()) {
			graf.inserirVertice(resultado.getInt("peso"), resultado.getString("ruaHorizontal"),
					resultado.getString("ruaVertical"),resultado.getInt("id"));
		}

		sql = "SELECT origem , destino FROM arestas;";
		comando = conn.prepareStatement(sql);
		resultado = comando.executeQuery();
		while (resultado.next()) {
			graf.inserirArestaSql(resultado.getInt("origem"), resultado.getInt("destino"));
		}

	}
	
	

	public static void insert(String sql) throws Exception {
		Connection conn = Conexao.abrir();
		/* Mapeamento objeto relacional */
		PreparedStatement comando = conn.prepareStatement(sql);
		// Executa a instrução SQL
		comando.execute();
	}

}
