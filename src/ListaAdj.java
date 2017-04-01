public class ListaAdj {

	private Lista<Vertice> vertices = new Lista<Vertice>();
	int contador =1;

	public void inserirVertice(String ruaHorizontal, String ruaVertical, int peso) { // esse é usado pelo interf
		Vertice v = new Vertice(contador, peso, ruaVertical, ruaHorizontal,false);
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

	public void inserirVertice(int peso, String ruaHorizontal, String ruaVertical, int id) { // esse pelo sql
		Vertice v = new Vertice (peso,id, ruaVertical, ruaHorizontal,false);
		vertices.inserir(v);
		contador= id + 1;
	}

	public void inserirAresta(int origem,int destino) {//inserir arestas
		Vertice v = vertices.obter(new Vertice(origem));//compara o vertice clone com o vertice real v de origem
		Vertice v1 = vertices.obter(new Vertice(destino));//compara o vertice clone com o vertice real v1 de destino
		if (v != null && v1 != null) {//se não forem nulos (será nulo caso não tenha nada na caixa de add aresta na interface)
			v.inserirAdj(v1);//insere-se um vertice de destino
			Aresta temp = new Aresta(v,v1);//cria-se uma aresta temporaria para entre os vertices
			String sql ="INSERT INTO `grafo`.`arestas` (`origem`, `destino`, `peso`, `rua`) VALUES ("+temp.getOrigem().getId()+","+ temp.getDestino().getId()+ "," + temp.getPeso()+", '"+temp.getRua()+"');";
			try {
				Conexao.insert(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ruas.inserir(new Aresta(v, v1, v1.getPeso())); //talvez
		} else {
			System.out.println("Vertice não existe");
		}
	}
	public void inserirArestaSql(int id , int id2) {
		//banco de dados
		Vertice v = vertices.obter(new Vertice(id));
		Vertice v1 = vertices.obter(new Vertice(id2));
		if (v != null && v1 != null) {
			v.inserirAdj(v1);
			// ruas.inserir(new Aresta(v, v1, v1.getPeso())); //talvez
		} else {
			System.out.println("Vertice não existe");
		}
	}

	public void removerAresta(int origem,int destino) {//remoção de arestas
		Vertice v = vertices.obter(new Vertice(origem));
		Vertice v1 = vertices.obter(new Vertice(destino));
		if (v != null && v1 != null) {
			// ruas.remover(new Aresta(v, v1, v1.getPeso()));
			Aresta temp = new Aresta(v,v1);
			String sql ="DELETE FROM `grafo`.`arestas` WHERE `origem`= "+temp.getOrigem().getId()+" AND `destino`= "+ temp.getDestino().getId()+ " LIMIT 1;";
			try {
				Conexao.insert(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			v.removerAdj(v1);
		} else {
			System.out.println("Vertice não existe, logo a Aresta não existe");
		}
	}

	public Aresta getAresta(String ruaHorizontal, String ruaVertical, String ruaHorizontal2, String ruaVertical2) {
		Vertice v = vertices.obter(new Vertice(ruaVertical, ruaHorizontal));
		Vertice v1 = v.getAdj().obter(new Vertice(ruaVertical2, ruaHorizontal2));
		if (v != null && v1 != null) {
			return new Aresta(v, v1);
		} else {
			return null;
		}
	}

	public void removerVertice(String ruaHorizontal, String ruaVertical) {
		Vertice v = vertices.obter(new Vertice(ruaVertical, ruaHorizontal));//tenho	
		if (v!=null) {
			//for (int i = 1; i <= vertices.getNelementos(); i++) {
			//	v.imprimirArestas();
			//	vertices.obterPosição(i).removerAdj2(v);
			//}
			String sql ="DELETE FROM `grafo`.`vertices` WHERE `id`='"+v.getId()+"';";
			vertices.remover(v);
			try {
				Conexao.insert(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// que	visualizar

		}
	}
	
	
	public Lista<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(Lista<Vertice> vertices) {
		this.vertices = vertices;
	}


	
	public void imprimirGrafo() {
		for (int i = 1; i <= vertices.getNelementos(); i++) {
			vertices.obterPosição(i).imprimirArestas();
			
		}
		System.out.println("\n");
	}

}