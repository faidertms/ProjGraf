
public class Aresta {
	private Vertice origem;
	private Vertice destino;
	private String rua;
	private int peso;
	public Vertice getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	Aresta(Vertice origem, Vertice destino) {
		this.origem = origem;
		this.destino = destino;
		this.peso = (origem.getPeso() + destino.getPeso())/2;
		if(origem.getRuaHorizontal() == destino.getRuaHorizontal() || origem.getRuaHorizontal() == destino.getRuaVertical()){
			this.rua = origem.getRuaHorizontal();
		}else{
			this.rua = origem.getRuaVertical();
		}
	}

	public Vertice getOrigem() {
		return origem;
	}

	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}


	public void setDestino(Vertice destino) {
		this.destino = destino;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Aresta) {
			return ((origem == ((Aresta) obj).origem) && (destino == ((Aresta) obj).destino));
		}
		return false;
	}
}
