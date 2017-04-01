
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
		contador = 1;
		for (int i = 0; i < this.numVertices; i++) {
			for (int j = 0; j < this.numVertices; j++) {
				this.matrizAdj[i][j] = 0;
			}
		}
	}

	
	public void inserirVertice(String ruaHorizontal, String ruaVertical, int peso){
		Vertice v = new Vertice (peso,contador, ruaVertical, ruaHorizontal,true);
		vertices.inserir(v);
		
		String sql = "INSERT INTO `grafo`.`vertices` (`id`, `ruaHorizontal`, `ruaVertical`, `peso`) VALUES("+contador+"," + "'"+ruaHorizontal+ "'" +"," +"'"+ ruaVertical+"'" +" ,"+"'" + peso +"'"+");";
		try {
			Conexao.insert(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contador++;
	}
	
	public void inserirVertice(int peso, String ruaHorizontal, String ruaVertical,int id) {
		Vertice v = new Vertice (peso,id, ruaVertical, ruaHorizontal,true);
		vertices.inserir(v);
		contador = id + 1;
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
			String sql ="DELETE FROM `grafo`.`vertices` WHERE `id`='"+v.getId()+"';";
			try {
				Conexao.insert(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vertices.remover(v);
			//contador--;// tenho
						// que
						// visualizar
		}
	}

	public void inserirAresta(String ruaHorizontal, String ruaVertical, String ruaHorizontal2, String ruaVertical2) throws Exception {
		Vertice v = vertices.obter(new Vertice(ruaVertical, ruaHorizontal));
		Vertice v1 = vertices.obter(new Vertice(ruaVertical2, ruaHorizontal2));
		if (v != null && v1 != null) {
			this.matrizAdj[v.getId()][v1.getId()] += 1;
			Aresta temp = new Aresta(v,v1);
			String sql ="INSERT INTO `grafo`.`arestas` (`origem`, `destino`, `peso`, `rua`) VALUES ("+temp.getOrigem().getId()+","+ temp.getDestino().getId()+ "," + temp.getPeso()+", '"+temp.getRua()+"');";
			Conexao.insert(sql);
			System.out.println("Adicionado");
		}else{
			System.out.println("Não existe");
		}
	}
	
	public void inserirAresta(int idOrigem, int idDestino) {
		Vertice v = vertices.obter(new Vertice(idOrigem));
		Vertice v1 = vertices.obter(new Vertice(idDestino));
		if (v != null && v1 != null) {
			this.matrizAdj[v.getId()][v1.getId()] += 1;
			Aresta temp = new Aresta(v,v1);
			String sql ="INSERT INTO `grafo`.`arestas` (`origem`, `destino`, `peso`, `rua`) VALUES ("+temp.getOrigem().getId()+","+ temp.getDestino().getId()+ "," + temp.getPeso()+", '"+temp.getRua()+"');";
			try {
				Conexao.insert(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Adicionado");
		}else{
			System.out.println("Não existe");
		}
	}
	
	public void insereArestaSql(int origem,int destino) throws Exception {
		if (origem != 0 && destino != 0) {
			this.matrizAdj[origem][destino] += 1;
			System.out.println("Adicionado");
		}else{
			System.out.println("Não existe");
		}
	}

	public void removerAresta(String ruaHorizontal, String ruaVertical, String ruaHorizontal2, String ruaVertical2)  {
		Vertice v = vertices.obter(new Vertice(ruaVertical, ruaHorizontal));
		Vertice v1 = vertices.obter(new Vertice(ruaVertical2, ruaHorizontal2));
		if (v != null && v1 != null && this.matrizAdj[v.getId()][v1.getId()] !=0) {
			Aresta temp = new Aresta(v,v1);
			String sql ="DELETE FROM `grafo`.`arestas` WHERE `origem`= "+temp.getOrigem().getId()+" AND `destino`= "+ temp.getDestino().getId()+ " LIMIT 1;";
			this.matrizAdj[v.getId()][v1.getId()] -=1;
			try {
				Conexao.insert(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Removido");
		}
	}
	
	public void removerAresta(int idOrigem, int idDestino)  {
		Vertice v = vertices.obter(new Vertice(idOrigem));
		Vertice v1 = vertices.obter(new Vertice(idDestino));
		if (v != null && v1 != null && this.matrizAdj[v.getId()][v1.getId()] != 0) {
			Aresta temp = new Aresta(v,v1);
			String sql ="DELETE FROM `grafo`.`arestas` WHERE `origem`= "+temp.getOrigem().getId()+" AND `destino`= "+ temp.getDestino().getId()+ " LIMIT 1;";
			this.matrizAdj[v.getId()][v1.getId()] -=1;
			try {
				Conexao.insert(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	public String imprimirGrafo() {
		String temp = "   ";
		System.out.println("Legenda: Não existe = 0 | Qualquer outro valor é o numero de Aresta");
		for (int i = 1; i <= this.vertices.getNelementos(); i++) {
			temp += i + "   ";
		}
		temp += "\n";
		temp+="------------------------------------------";
		temp ="";
		for (int i = 1; i <= this.vertices.getNelementos(); i++) {
			temp += i + " | "  ;
								// vertices.obterPosição(i).getRuaHorizontal()+"/"+
								// vertices.obterPosição(i).getRuaVertical() +
								// ": ";
			for (int j = 1; j <= this.vertices.getNelementos(); j++) {
				temp += this.matrizAdj[i][j] + " , ";
			}
			//System.out.println(temp);
			temp += "\n";
		}
		System.out.println(temp);
		return temp;
	}

	public Lista<Aresta> getRuas() {
		return ruas;
	}

	public void setRuas(Lista<Aresta> ruas) {
		this.ruas = ruas;
	}	
	

	public Lista<Vertice> getVertices() {
		return vertices;
	}


	public void setVertices(Lista<Vertice> vertices) {
		this.vertices = vertices;
	}
	

	public int[][] getMatrizAdj() {
		return matrizAdj;
	}


	public void setMatrizAdj(int[][] matrizAdj) {
		this.matrizAdj = matrizAdj;
	}
}
//Select * from grafo.vertices as c inner join grafo.arestas as d on c.id =  d.origem OR c.id =  d.destino;