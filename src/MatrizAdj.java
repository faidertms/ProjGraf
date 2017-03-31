import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MatrizAdj {
	private int matrizAdj[][];
	private Lista<Vertice> vertices = new Lista<Vertice>();
	private Lista<Aresta> ruas = new Lista<Aresta>();
	private int numVertices;
	int contador;

	public MatrizAdj(int numVertices) {
		super();
		this.matrizAdj = new int[numVertices][numVertices];
		this.numVertices = numVertices;
		contador = 0;
		for (int i = 0; i < this.numVertices; i++) {
			for (int j = 0; j < this.numVertices; j++) {
				this.matrizAdj[i][j] = 0;
			}
		}
	}

	public void inserirVertice(String ruaHorizontal, String ruaVertical, int peso) throws Exception {
		Vertice v = new Vertice (peso,contador, ruaVertical, ruaHorizontal);
		vertices.inserir(v);
		contador++;
		String sql = "INSERT INTO `grafo`.`vertices` (`id`, `ruaHorizontal`, `ruaVertical`, `peso`) VALUES("+contador+"," + "'"+ruaHorizontal+ "'" +"," +"'"+ ruaVertical+"'" +" ,"+"'" + peso +"'"+");";
		//Prepara a instrução SQL
		Connection conn = Conexao.abrir();
        /* Mapeamento objeto relacional */
        PreparedStatement comando = conn.prepareStatement(sql);
		//Executa a instrução SQL
		comando.execute();
		// vertices.imprimirLista();
	}
	
	public void inserirVertice(int peso, String ruaHorizontal, String ruaVertical) {
		Vertice v = new Vertice (peso,contador, ruaVertical, ruaHorizontal);
		vertices.inserir(v);
		contador++;
	}
	

	public void removerVertice(String ruaHorizontal, String ruaVertical) {
		if (vertices.encontrarElemento(new Vertice(ruaVertical, ruaHorizontal))) {
			Vertice v = vertices.obter(new Vertice(ruaVertical, ruaHorizontal));
			for (int i = 0; i < numVertices; i++) {
				this.matrizAdj[i][v.getId()] = 0;
			}
			for (int j = 0; j < numVertices; j++) {
				this.matrizAdj[v.getId()][j] = 0;
			}
			vertices.remover(new Vertice(ruaVertical, ruaHorizontal));
			contador--;// tenho
						// que
						// visualizar
		}
	}

	public void insereAresta(String ruaHorizontal, String ruaVertical, String ruaHorizontal2, String ruaVertical2) {
		Vertice v = vertices.obter(new Vertice(ruaVertical, ruaHorizontal));
		Vertice v1 = vertices.obter(new Vertice(ruaVertical2, ruaHorizontal2));
		if (v != null && v1 != null) {
			this.matrizAdj[v.getId()][v1.getId()] = 1;
			System.out.println("Adicionado");
		}else{
			System.out.println("Não existe");
		}
	}

	public void removerAresta(String ruaHorizontal, String ruaVertical, String ruaHorizontal2, String ruaVertical2) {
		Vertice v = vertices.obter(new Vertice(ruaVertical, ruaHorizontal));
		Vertice v1 = vertices.obter(new Vertice(ruaVertical2, ruaHorizontal2));
		if (v != null && v1 != null) {
			this.matrizAdj[v.getId()][v1.getId()] = 0;
			System.out.println("Removido");
		}
	}

	public Aresta getAresta(String ruaHorizontal, String ruaVertical, String ruaHorizontal2, String ruaVertical2) {
		Vertice v = vertices.obter(new Vertice(ruaVertical, ruaHorizontal));
		Vertice v1 = vertices.obter(new Vertice(ruaVertical2, ruaHorizontal2));
		if (v != null && v1 != null) {
			if (this.matrizAdj[v.getId()][v1.getId()] == 1) {
				return new Aresta(v, v1);
			}
		}
		return null;
	}

	public void imprimirGrafo() {
		String temp = "   ";
		System.out.println("Legenda: Não existe = 0 | Qualquer outro valor é o numero de Aresta");
		for (int i = 0; i < this.contador; i++) {
			temp += i + "    ";
		}
		System.out.println(temp);
		System.out.println("-----------------------");
		for (int i = 0; i < this.contador; i++) {
			temp = i + " | "  +
								 vertices.obterPosição(i+1).getRuaHorizontal()+"/"+
								 vertices.obterPosição(i+1).getRuaVertical() +
								 ": ";
			for (int j = 0; j < this.contador; j++) {
				temp += this.matrizAdj[i][j] + " , ";
			}
			System.out.println(temp);
			temp = "";
		}
	}

}
