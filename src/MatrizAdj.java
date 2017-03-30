public class MatrizAdj {
	private int matrizAdj[][];
	private Lista<Vertice> vertices = new Lista<Vertice>();
	private Lista<Aresta> ruas = new Lista<Aresta>();
	private int numVertices;

	public MatrizAdj(int numVertices) {
		super();
		this.matrizAdj = new int[numVertices][numVertices];
		this.numVertices = numVertices;
		for (int i = 0; i < this.numVertices; i++) {
			for (int j = 0; j < this.numVertices; j++) {
				this.matrizAdj[i][j] = 0;
			}
		}
	}

	public void inserirVertice(String ruaHorizontal, String ruaVertical, int peso, int id) {
		Vertice v = new Vertice(id, peso, ruaVertical, ruaHorizontal);
		vertices.inserir(v);
		// vertices.imprimirLista();
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
			vertices.remover(new Vertice(ruaVertical, ruaHorizontal)); // tenho
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
		String temp;
		System.out.println("Legenda: Não existe = -1 | Qualquer outro valor é o peso da Aresta");
		for (int i = 0; i < this.numVertices; i++) {
			temp = "Vertice " + i + ": ";
			for (int j = 0; j < this.numVertices; j++) {
				temp += this.matrizAdj[i][j] + " , ";
			}
			System.out.println(temp);
			temp = "";
		}
	}

}
