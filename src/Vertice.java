//criação da classe vertice, definindo as ruas horizontais e verticais, bem como o peso dos vertices entre 
//essas ruas, bem como a identificação dos cruzamentos (vertices).
public class Vertice {
	private int id;
	private String ruaVertical, ruaHorizontal;
	private int peso;
	private Lista<Vertice> adj;

	// definindo os parametros do vertice \/
	Vertice(String ruaVertical, String ruaHorizontal) {
		this.ruaVertical = ruaVertical;
		this.ruaHorizontal = ruaHorizontal;
		this.peso = 0;
		this.adj = null;
	}

	Vertice(int id) {
		this.id = id;
	}

	// recebe os parametros definidos
	Vertice(int peso, int id, String ruaVertical, String ruaHorizontal, boolean matrz) {
		this.id = id;
		this.ruaVertical = ruaVertical;
		this.ruaHorizontal = ruaHorizontal;
		this.peso = peso;
		if (matrz) {// se for matriz ok
			this.adj = null;
		} else {// senão for matriz será lista
			this.adj = new Lista<Vertice>();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void inserirAdj(Vertice p) {
		adj.inserir(p);
	}

	public String getRuaVertical() {
		return ruaVertical;
	}

	public void setRuaVertical(String ruaVertical) {
		this.ruaVertical = ruaVertical;
	}

	public String getRuaHorizontal() {
		return ruaHorizontal;
	}

	public void setRuaHorizontal(String ruaHorizontal) {
		this.ruaHorizontal = ruaHorizontal;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Lista<Vertice> getAdj() {
		return adj;
	}

	public void setAdj(Lista<Vertice> adj) {
		this.adj = adj;
	}

	public void removerAdj(Vertice p) {
		this.adj.remover(p);
	}

	public void removerAdj2(Vertice p) {
		for (int z = 1; z <= adj.getNelementos(); z++) {
			if (this.adj.remover(p)) {
				z = 1;
			}
		}
	}

	public void imprimirArestas() { // metodo para imprimir uma aresta entre
									// dois vertices
		String aux = ruaHorizontal + "/" + ruaVertical + " --> ";
		Vertice temp;
		for (int z = 1; z <= adj.getNelementos(); z++) {
			temp = adj.obterPosição(z);
			aux = aux + temp.getRuaHorizontal() + "/" + temp.getRuaVertical() + " , ";
		}
		System.out.println(aux);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Vertice) {
			return ((ruaHorizontal.equals(((Vertice) obj).ruaHorizontal)
					&& ruaVertical.equals(((Vertice) obj).ruaVertical)) || (id == ((Vertice) obj).id));
		}
		return false;
	}
}
