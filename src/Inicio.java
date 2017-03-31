import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Inicio {

	public static void main(String[] args) throws Exception {
		// seleciona o tipo de estrutura
		// puxa os dados ja existente pra estrutura
		// inicia a interface grafica de adcionar / remover
		MatrizAdj graf = new MatrizAdj(8);
	       StringBuilder sql = new StringBuilder();
	        sql.append("SELECT *");
	        sql.append("FROM vertices;");
	        /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
	        Connection conn = Conexao.abrir();

	        /* Mapeamento objeto relacional */
	        PreparedStatement comando = conn.prepareStatement(sql.toString());
			ResultSet resultado = comando.executeQuery();
			 while (resultado.next()) {
				 graf.inserirVertice(resultado.getInt("peso"),resultado.getString("ruaHorizontal"), resultado.getString("ruaVertical"));
			 }
			 graf.imprimirGrafo();
		
		
		//graf.inserirVertice("Av.Dom Luis", "Osvaldo Cruz", 4);
		//graf.inserirVertice("Rua Marcos Macedo", "Osvaldo Cruz", 1);
		//graf.inserirVertice("Rua Pereira Valente", "Osvaldo Cruz", 1);
		graf.insereAresta("Av.Dom Luis", "Osvaldo Cruz","Rua Marcos Macedo", "Osvaldo Cruz");
		graf.imprimirGrafo();
		
 
		
		/*ListaAdj graf = new ListaAdj();
		graf.inserirVertice("Thiago");
		graf.inserirVertice("Sales");
		graf.inserirVertice("Tairone");
		graf.inserirAresta("Sales", "Tairone");
		graf.inserirAresta("Thiago","Sales");
		graf.inserirAresta("Thiago","Tairone");
		graf.inserirAresta("Tairone","Sales");
		//graf.removerAresta("Thiago","Sales");
		graf.imprimirGrafo();*/
		
		// Teste
		/*Lista<No> l = new Lista<No>();
		No<Integer> t = new No<Integer>(1);
		No<Integer> t2 = new No<Integer>(2);
		No<Integer> t3 = new No<Integer>(3);
		No<Integer> t5 = new No<Integer>(3);
		l.inserir(t);
		l.inserir(t2);
		l.inserir(t3);
		l.imprimirLista();
		System.out.println("Separa");
		
		l.imprimirLista();
		l.imprimirNelementos();
		System.out.println("Separa");l.remover(t);
		System.out.println(l.obter(t)); // fazer umas modificação no obter no
		System.out.println("Separa-T");
		
		l.remover(t5);
		l.remover(t2);
		
		System.out.println(l.encontrarElemento(t2));
		l.imprimirLista();*/

}
}
