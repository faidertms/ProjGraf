
public class No<T> {

	private No<T> proximo = null;
	private T numero;

	public No(T numero) {
		this.numero = numero;
	}

	public void setproximo(No<T> p) {
		proximo = p;
	}

	public void setnumero(T p) {
		numero = p;
	}

	public No<T> getproximo() {
		return proximo;
	}

	public T getnumero() {
		return numero;
	}

	public boolean equals(Object obj) {
		if (obj instanceof No) {
			return ((numero == ((No<?>) obj).numero) && (proximo == ((No<?>) obj).proximo));
		}
		return false;
	}

}
