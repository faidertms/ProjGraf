import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class interf extends JFrame {
	public static JTable table;
	private JTextField id;
	private JTextField avenida;
	private JTextField avenida2;
	private JTextField peso;
	static MatrizAdj graf;
	static ListaAdj graf2;
	static RuaTableModel modelo;
	boolean aresta = false;
	private JTextField id2;
	JTextArea textPane;
	static boolean matriz;
	static Busca b = new Busca();
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void startM(){
		graf = new MatrizAdj(64);
		try {
			Conexao.insert("call grafo.update_id;");
			Conexao.atualizar(graf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelo.adicionar(graf.getVertices());
		
	}
	
	public static void startL(){
		graf2.getVertices().zerarLista();
		try {
			Conexao.insert("call grafo.update_id;");
			Conexao.atualizar(graf2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		modelo.adicionar(graf2.getVertices());
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interf frame = new interf();
					modelo = (RuaTableModel) table.getModel();
					if (JOptionPane.showConfirmDialog(null,
							"Voce gostaria de Qual Estrutura Sim(MatrizAdj) ou Não(ListaAdj)?", "Tipo de Estrutura",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						startM();
						int [] t =b.BuscaLargura(graf,1);
						for(int i=1; i<=15;i++){
						System.out.println(t[i]);}
						matriz = true;
					} else {
						
						matriz = false;
						graf2 = new ListaAdj();
						startL();
						int [] t =b.BuscaLargura(graf2,1);
						for(int i=1; i<=15;i++){
						System.out.println(t[i]);}
						//System.out.println(graf2.getVertices().getNelementos());
					}
					

					 //graf2 = new ListaAdj();

					//Conexao.atualizar(graf2);

					//modelo = (RuaTableModel) table.getModel();

					// Select * from grafo.vertices as c inner join
					// grafo.arestas as d on c.id = d.origem OR c.id =
					// d.destino;

					frame.setVisible(true);
					//modelo.adicionar(graf2.getVertices());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interf() {
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 30, 532, 129);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				avenida.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				avenida2.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				peso.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new RuaTableModel());
		table.getColumnModel().getColumn(0).setPreferredWidth(76);

		JButton btnNewButton_2 = new JButton("Adicionar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Integer.parseInt
				if (aresta) {
					if (matriz) {
						graf.inserirAresta(Integer.parseInt(id.getText()), Integer.parseInt(id2.getText()));
						showmatriz();
					} else {
						graf2.inserirAresta(Integer.parseInt(id.getText()), Integer.parseInt(id2.getText()));
						graf2.imprimirGrafo();
					}
				} else {
					if (matriz) {
						graf.inserirVertice(avenida.getText(), avenida2.getText(), Integer.parseInt(peso.getText()));
						modelo.adicionar(graf.getVertices());
					} else {
						graf2.inserirVertice(avenida.getText(), avenida2.getText(), Integer.parseInt(peso.getText()));
						modelo.adicionar(graf2.getVertices());
					}
				}
			}
		});
		btnNewButton_2.setBounds(369, 202, 89, 21);
		getContentPane().add(btnNewButton_2);

		id = new JTextField();
		id.setBounds(25, 203, 46, 20);
		getContentPane().add(id);
		id.setColumns(10);

		avenida = new JTextField();
		avenida.setBounds(81, 203, 105, 20);
		getContentPane().add(avenida);
		avenida.setColumns(10);

		avenida2 = new JTextField();
		avenida2.setBounds(196, 203, 107, 20);
		getContentPane().add(avenida2);
		avenida2.setColumns(10);

		peso = new JTextField();
		peso.setBounds(313, 203, 46, 20);
		getContentPane().add(peso);
		peso.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(25, 188, 46, 14);
		getContentPane().add(lblId);

		JLabel lblAvenida = new JLabel("Avenida");
		lblAvenida.setBounds(81, 188, 46, 14);
		getContentPane().add(lblAvenida);

		JLabel lblAvenida_1 = new JLabel("Avenida 2");
		lblAvenida_1.setBounds(196, 188, 57, 14);
		getContentPane().add(lblAvenida_1);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(313, 188, 46, 14);
		getContentPane().add(lblPeso);
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aresta) {
					if (matriz) {
						graf.removerAresta(Integer.parseInt(id.getText()), Integer.parseInt(id2.getText()));
						showmatriz();
					} else {
						graf2.removerAresta(Integer.parseInt(id.getText()), Integer.parseInt(id2.getText()));
						graf2.imprimirGrafo();
					}
				} else {
					if (matriz) {
						graf.removerVertice(avenida.getText(), avenida2.getText());
						startM();
					} else {
						graf2.removerVertice(avenida.getText(), avenida2.getText());
						startL();
					}
				}
			}
		});
		btnRemover.setBounds(468, 202, 89, 21);
		getContentPane().add(btnRemover);

		textPane = new JTextArea();
		textPane.setEditable(false);
		textPane.setBounds(25, 266, 550, 400);
		// textPane.setLayout(new GridLayout(7, 7)); // PEGA o VALOR DO ELEMENTO
		getContentPane().add(textPane);
		textPane.setVisible(false);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 46, 21);
		getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmVertice = new JMenuItem("Vertice");
		mntmVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avenida2.setVisible(true);
				avenida.setVisible(true);
				peso.setVisible(true);
				id2.setVisible(false);
				lblAvenida.setText("Avenida");
				lblAvenida_1.setVisible(true);
				lblPeso.setVisible(true);
				aresta = false;
				textPane.setVisible(false);
			}
		});
		mnNewMenu.add(mntmVertice);

		JMenuItem mntmArestas = new JMenuItem("Arestas");
		mntmArestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// graf.inserirAresta(id., int idDestino)
				avenida2.setVisible(false);
				avenida.setVisible(false);
				peso.setVisible(false);
				id2.setVisible(true);
				lblAvenida.setText("ID 2");
				lblAvenida_1.setVisible(false);
				lblPeso.setVisible(false);
				aresta = true;
				if (matriz) {
					showmatriz();
				}else{
					graf2.imprimirGrafo();
				}

			}
		});
		mnNewMenu.add(mntmArestas);

		id2 = new JTextField();
		id2.setBounds(81, 203, 46, 21);
		getContentPane().add(id2);
		id2.setVisible(false);
		id2.setColumns(10);
	}

	public void showmatriz() {//função para mostrar a matriz que aparece na interface
		int[][] t = graf.getMatrizAdj();
		textPane.removeAll();//manipular o jtextArea \/
		textPane.setVisible(false);
		textPane.setLayout(new GridLayout(graf.getVertices().getNelementos(), graf.getVertices().getNelementos()));
		for (int i = 1; i <= graf.getVertices().getNelementos(); i++) {
			for (int j = 1; j <= graf.getVertices().getNelementos(); j++) {
				textPane.add(new Random(t[i][j]));
			}
		}
		textPane.update(textPane.getGraphics());
		textPane.setVisible(true);
	}

}
