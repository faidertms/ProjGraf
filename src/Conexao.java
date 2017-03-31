import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String USUARIO = 
    private static final String SENHA = 
    private static final String URL = "jdbc:mysql://.com:3306/grafo";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Conectar ao banco
    public static Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;


    }

}