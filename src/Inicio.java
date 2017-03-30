
public class Inicio {

	public static void main(String[] args) {
		
		
		MatrizAdj graf = new MatrizAdj(3);
		graf.insereAresta(0, 1, 1);
		graf.insereAresta(1, 2, 3);
		graf.insereAresta(2, 1, 0);
		graf.imprimirGrafo();
		
		
		/*ListaAdj graf = new ListaAdj();
		graf.inserirVertice("Thiago");
		graf.inserirVertice("Sales");
		graf.inserirVertice("Tairone");
		graf.inserirAresta("Sales", "Tairone");
		graf.inserirAresta("Thiago","Sales");
		graf.inserirAresta("Thiago","Tairone");
		graf.inserirAresta("Tairone","Sales");
		//graf.removerAresta("Thiago","Sales");
		graf.imprimirGrafo();*/
		
		// Teste
		/*Lista<No> l = new Lista<No>();
		No<Integer> t = new No<Integer>(1);
		No<Integer> t2 = new No<Integer>(2);
		No<Integer> t3 = new No<Integer>(3);
		No<Integer> t5 = new No<Integer>(3);
		l.inserir(t);
		l.inserir(t2);
		l.inserir(t3);
		l.imprimirLista();
		System.out.println("Separa");
		
		l.imprimirLista();
		l.imprimirNelementos();
		System.out.println("Separa");l.remover(t);
		System.out.println(l.obter(t)); // fazer umas modificação no obter no
		System.out.println("Separa-T");
		
		l.remover(t5);
		l.remover(t2);
		
		System.out.println(l.encontrarElemento(t2));
		l.imprimirLista();*/
	}

}
