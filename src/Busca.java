import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Busca {
	public int[] BuscaProfudindade(ListaAdj graf, int id_inicial) {
		int[] vetor = new int[graf.getVertices().getNelementos() + 1];
		int contador = 1;
		for (int i = 1; i <= graf.getVertices().getNelementos(); i++) {
			vetor[i] = 0;
		}
		BuscaProfudindade(graf, id_inicial, vetor, contador);
		return vetor;

	}

	private void BuscaProfudindade(ListaAdj graf, int id_inicial, int[] vetor, int contador) {
		Vertice aux = graf.getVertices().obter(new Vertice(id_inicial));
		int temp = aux.getAdj().getNelementos();
		vetor[id_inicial] = contador;
		for (int i = 1; i <= temp; i++) {

			Vertice aux2 = aux.getAdj().obterPosição(i);
			if (aux2 != null && (0 == vetor[aux2.getId()])) {
				BuscaProfudindade(graf, aux2.getId(), vetor, contador + 1);
			}
		}

	}

	public int[] BuscaProfudindade(MatrizAdj graf, int id_inicial) {
		int[] vetor = new int[graf.getVertices().getNelementos() + 1];
		int contador = 1;
		for (int i = 1; i <= graf.getVertices().getNelementos(); i++) {
			vetor[i] = 0;
		}
		BuscaProfudindade(graf, id_inicial, vetor, contador);
		return vetor;

	}

	private void BuscaProfudindade(MatrizAdj graf, int id_inicial, int[] vetor, int contador) {
		Vertice aux = graf.getVertices().obter(new Vertice(id_inicial));
		int temp = graf.getVertices().getNelementos();
		vetor[id_inicial] = contador;
		for (int i = 1; i <= temp; i++) {
			if (graf.getMatrizAdj()[aux.getId()][i] != 0 && (0 == vetor[i])) {
				BuscaProfudindade(graf, i, vetor, contador + 1);
			}
		}

	}

	public int[] BuscaLargura(ListaAdj graf, int id_inicial) {
		int[] vetor = new int[graf.getVertices().getNelementos() + 1];
		int contador = 1;
		Queue<Vertice> fila = new LinkedList<Vertice>();

		for (int i = 1; i <= graf.getVertices().getNelementos(); i++) {
			vetor[i] = 0;
		}
		Vertice aux = graf.getVertices().obter(new Vertice(id_inicial));
		vetor[id_inicial] = contador;
		fila.add(aux);
		while (!fila.isEmpty()) {
			contador++;
			aux = fila.poll();
			int temp = aux.getAdj().getNelementos();
			for (int i = 1; i <= temp; i++) {
				Vertice aux2 = aux.getAdj().obterPosição(i);
				if (aux2 != null && (0 == vetor[aux2.getId()])) {
					fila.add(aux2);
					vetor[aux2.getId()] = contador;
				}
			}
		}
		return vetor;
	}

	public int[] BuscaLargura(MatrizAdj graf, int id_inicial) {
		int[] vetor = new int[graf.getVertices().getNelementos() + 1];
		int contador = 1;
		Queue<Vertice> fila = new LinkedList<Vertice>();

		for (int i = 1; i <= graf.getVertices().getNelementos(); i++) {
			vetor[i] = 0;
		}
		Vertice aux = graf.getVertices().obter(new Vertice(id_inicial));
		vetor[id_inicial] = contador;
		fila.add(aux);
		while (!fila.isEmpty()) {
			contador++;
			aux = fila.poll();
			int temp = graf.getVertices().getNelementos();
			for (int i = 1; i <= temp; i++) {
				if (graf.getMatrizAdj()[aux.getId()][i] != 0 && (0 == vetor[i])) {
					fila.add(graf.getVertices().obter(new Vertice(i)));
					vetor[i] = contador;
				}
			}
		}
		return vetor;
	}

	public void Dijktra(MatrizAdj graf, int id_inicial){
	 int temp = graf.getVertices().getNelementos();
	 int [] distancia = new int [temp+1];
	 int [] predecessor = new int [temp+1];
	 int peso;
	 Queue<Vertice> fila = new LinkedList<Vertice>();
	// PriorityQueue<Vertice> pq= new PriorityQueue<Vertice>(temp+1,);
	 for (int i = 1; i <= graf.getVertices().getNelementos();i++){
		 distancia[i] = 9999;
		 predecessor[i] = 0;
		 fila.add(graf.getVertices().obter(new Vertice(i)));
	 }
	 
	 
	 Vertice aux = graf.getVertices().obter(new Vertice(id_inicial));
	 distancia[id_inicial] = 0;
	 
	 while(!fila.isEmpty()){
		 for (int i = 1; i <= temp;i++){
			 if(fila.contains(graf.getVertices().obter(new Vertice(i))) && distancia[i] < distancia[aux.getId()]){
				 aux = graf.getVertices().obter(new Vertice(i));
			 }
		 }
		 fila.remove(aux);
		 for (int i = 1; i <= temp; i++){
			 peso = distancia[aux.getId()] + new Aresta(aux,graf.getVertices().obter(new Vertice(i))).getPeso();
			 if(graf.getMatrizAdj()[aux.getId()][i]!=0 &&  (distancia[i] > peso)){
				 distancia[i] = peso;
				 predecessor[i] = aux.getId();
			 }
		 }
		 aux= fila.peek();
	 }
		for(int i=1; i<=temp;i++){
		System.out.println(distancia[i] +" - " + predecessor[i]);}
	}
	public void Dijktra(ListaAdj graf, int id_inicial){
	 int temp = graf.getVertices().getNelementos();
	 int [] distancia = new int [temp+1];
	 int [] predecessor = new int [temp+1];
	 int peso;
	 Queue<Vertice> fila = new LinkedList<Vertice>();
	// PriorityQueue<Vertice> pq= new PriorityQueue<Vertice>(temp+1,);
	 for (int i = 1; i <= graf.getVertices().getNelementos();i++){
		 distancia[i] = 9999;
		 predecessor[i] = 0;
		 fila.add(graf.getVertices().obter(new Vertice(i)));
	 }
	 
	 
	 Vertice aux = graf.getVertices().obter(new Vertice(id_inicial));
	 distancia[id_inicial] = 0;
	 
	 while(!fila.isEmpty()){
		 for (int i = 1; i <= temp;i++){
			 if(fila.contains(graf.getVertices().obter(new Vertice(i))) && distancia[i] < distancia[aux.getId()]){
				 aux = graf.getVertices().obter(new Vertice(i));
			 }
		 }
		 fila.remove(aux);
		 for (int i = 1; i <= aux.getAdj().getNelementos(); i++){
			 Vertice aux2 = aux.getAdj().obterPosição(i);
			 peso = distancia[aux.getId()] + new Aresta(aux,aux2).getPeso();
				if (aux2 != null && (distancia[aux2.getId()] > peso)) {
				 distancia[aux2.getId()] = peso;
				 predecessor[aux2.getId()] = aux.getId();
			 }
		 }
		 aux= fila.peek();
	 }
		for(int i=1; i<=temp;i++){
		System.out.println(distancia[i] +" - " + predecessor[i]);}
	}
}