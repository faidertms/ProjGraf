public class ListaAdj {

	private Lista<Vertice> vertices = new Lista<Vertice>();
	private Lista<Aresta> ruas = new Lista<Aresta>();

	public void inserirVertice(String ruaHorizontal, String ruaVertical, int peso, int id) {
		Vertice v = new Vertice(id, peso, ruaVertical, ruaHorizontal);
		vertices.inserir(v);
		// vertices.imprimirLista();
	}

	public void inserirAresta(String ruaHorizontal, String ruaVertical, String ruaHorizontal2, String ruaVertical2) {
		Vertice v = vertices.obter(new Vertice(ruaVertical, ruaHorizontal));
		Vertice v1 = vertices.obter(new Vertice(ruaVertical2, ruaHorizontal2));
		if (v != null && v1 != null) {
			v.inserirAdj(v1);
			// ruas.inserir(new Aresta(v, v1, v1.getPeso())); //talvez
		} else {
			System.out.println("Vertice não existe");
		}
	}

	public void removerAresta(String ruaHorizontal, String ruaVertical, String ruaHorizontal2, String ruaVertical2) {
		Vertice v = vertices.obter(new Vertice(ruaVertical, ruaHorizontal));
		Vertice v1 = vertices.obter(new Vertice(ruaVertical2, ruaHorizontal2));
		if (v != null && v1 != null) {
			// ruas.remover(new Aresta(v, v1, v1.getPeso()));
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
		if (vertices.encontrarElemento(new Vertice(ruaVertical, ruaHorizontal))) {
			vertices.remover(new Vertice(ruaVertical, ruaHorizontal)); // tenho
																		// que	visualizar
		}
	}

	/*
	 * public void imprimirGrafo() { Vertice aux; for (int i = 1; i <=
	 * vertices.getNelementos(); i++) {
	 * vertices.obterPosição(i).imprimirArestas(); // System.out.println(); }
	 * 
	 * }
	 */

}
