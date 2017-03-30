
public class Vertice {
	private int id;
	private String  ruaVertical, ruaHorizontal;
	private int peso;
	private Lista<Vertice> adj;

	Vertice(String ruaVertical,String ruaHorizontal) {
		this.ruaVertical = ruaVertical;
		this.ruaHorizontal = ruaHorizontal;
		this.peso = 0;
		this.adj = null;
	}
	
	Vertice(int peso, int id, String ruaVertical, String ruaHorizontal) {
		this.id = id;
		this.ruaVertical = ruaVertical;
		this.ruaHorizontal = ruaHorizontal;
		this.peso = peso;
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

	// remover aresta recebe aresta
	/*public void imprimirArestas() {
		//String aux = rua + " --> ";
		for (int z = 1; z <= adj.getNelementos(); z++) {
		//	aux = aux + adj.obterPosição(z).getDestino().getNome() + " , ";
		}
		System.out.println(aux);
	}*/

	public boolean equals(Object obj) {
		if (obj instanceof Vertice) {
			return (ruaHorizontal.equals(((Vertice) obj).ruaHorizontal) && ruaVertical.equals(((Vertice) obj).ruaVertical));
		}
		return false;
	}
}
