
public class VerticeM {
	int id;
	private String ruaVertical, ruaHorizontal;
	private int peso;

	VerticeM(String ruaVertical, String ruaHorizontal) {
		this.ruaVertical = ruaVertical;
		this.ruaHorizontal = ruaHorizontal;
		this.peso = 0;
	}

	VerticeM(int peso, int id, String ruaVertical, String ruaHorizontal) {
		this.id = id;
		this.ruaVertical = ruaVertical;
		this.ruaHorizontal = ruaHorizontal;
		this.peso = peso;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// remover aresta recebe aresta
	/*
	 * public void imprimirArestas() { //String aux = rua + " --> "; for (int z
	 * = 1; z <= adj.getNelementos(); z++) { // aux = aux +
	 * adj.obterPosição(z).getDestino().getNome() + " , "; }
	 * System.out.println(aux); }
	 */

	public boolean equals(Object obj) {
		if (obj instanceof Vertice) {
			return (ruaHorizontal.equals(((VerticeM) obj).ruaHorizontal)
					&& ruaVertical.equals(((VerticeM) obj).ruaVertical));
		}
		return false;
	}
}
