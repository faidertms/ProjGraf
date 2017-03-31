
public class Lista<T> {

	private No<T> inicial = null;
	private int nelementos = 0;

	public void inserir(T p) {
		No<T> temp = new No<T>(p);

		if (inicial == null) {
			inicial = temp;
			nelementos++;
		} else {
			No<T> aux = inicial;
			while (aux != null) {
				if (aux.getproximo() == null) {
					aux.setproximo(temp);
					nelementos++;
					break;
				} else {
					aux = aux.getproximo();
				}
			}
		}
	}

	public void imprimirLista() {
		No<T> aux = inicial;
		while (aux != null) {
			System.out.println("Numero:" + aux.getnumero());
			aux = aux.getproximo();
		}
	}

	public boolean encontrarElemento(T p) {
		No<T> aux = inicial;
		while (aux != null) {
			if (aux.getnumero().equals(p)) {
				System.out.println("Elemento Encontrado");
				return true;
			}
			aux = aux.getproximo();
		}
		System.out.println("Elemento Não Encontrado");
		return false;
	}

	public void imprimirNelementos() {
		System.out.println(nelementos);
	}

	public int getNelementos() {
		return nelementos;
	}

	public T obter(T p) {
		No<T> aux = inicial;
		while (aux != null) {
			if (aux.getnumero().equals(p)) {
				return aux.getnumero();
			} else if (aux.getproximo() == null) {
				System.out.println("Elemento não existe");
				//aux = null; // faz o tratamento no programa
				return null;

			} else {
				aux = aux.getproximo();
			}

		}
		return null;
	}

	public void remover(T p) {
		No<T> aux = inicial;
		No<T> aux2 = null;
		if (inicial.getnumero().equals(p)) {
			inicial = inicial.getproximo();
			nelementos--;
		} else {
			while (aux != null) {
				if (aux.getnumero().equals(p)) {
					if (aux.getproximo() == null) {
						nelementos--;
						aux2.setproximo(null);
						break;
					} else {
						aux2.setproximo(aux.getproximo());
						nelementos--;
						break;
					}
				} else {
					aux2 = aux;
					aux = aux.getproximo();
				}
			}
		}
	}

	public T obterPosição(int n) {
		No<T> aux = inicial;
		int contador = 1;
		if (n <= nelementos) {
			while (contador < n) {
				aux = aux.getproximo();
				contador++;
			}
			return aux.getnumero();
		} else {
			System.out.println("Posição inexistente");
			return null;
		}
	}
	
	public int EncontraPosElemento(T p) {
		No<T> aux = inicial;
		int contador = 1;
		while (aux != null) {
			if (aux.getnumero().equals(p)) {
				System.out.println("Elemento Encontrado");
				return contador;
			}
			contador++;
			aux = aux.getproximo();
		}
		System.out.println("Elemento Não Encontrado");
		return -1;
	}

}
