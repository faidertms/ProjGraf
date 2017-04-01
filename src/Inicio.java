import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Inicio {
	static Busca b = new Busca();
	public static void main(String[] args) throws Exception {
		// seleciona o tipo de estrutura
		// puxa os dados ja existente pra estrutura
		// inicia a interface grafica de adcionar / remover
		MatrizAdj graf = new MatrizAdj(8);
	      /*StringBuilder sql = new StringBuilder();
	        sql.append("SELECT *");
	        sql.append("FROM vertices;");
	         //Abre a conexão que criamos o retorno é armazenado na variavel conn */
	
	        /*PreparedStatement comando = conn.prepareStatement(sql.toString());
			ResultSet resultado = comando.executeQuery();
			 while (resultado.next()) {
				 graf.inserirVertice(resultado.getInt("peso"),resultado.getString("ruaHorizontal"), resultado.getString("ruaVertical"));
			 }
			 graf.imprimirGrafo();*/
		
		//(int peso, String ruaHorizontal, String ruaVertical,int id)
		graf.inserirVertice(4,"Av.Dom Luis", "Osvaldo Cruz", 1);
		graf.inserirVertice(8,"Rua Marcos Macedo", "Osvaldo Cruz", 2);
		graf.inserirVertice(6,"Rua Pereira Valente", "Osvaldo Cruz", 3);
		graf.inserirVertice(0,"Rua Pereira Valene", "Osvaldo ruz", 4);
		graf.inserirVertice(0,"Rua Pereira Valene", "Osvaldo ruz", 5);
		graf.insereArestaSql(1,2);
		graf.insereArestaSql(1,3);
		graf.insereArestaSql(2, 3);
		graf.insereArestaSql(2,4);
		graf.insereArestaSql(5,4);
		graf.insereArestaSql(3,5);
		//graf.insereArestaSql(4,3);
		b.Dijktra(graf, 1);
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
