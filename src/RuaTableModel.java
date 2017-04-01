import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class RuaTableModel extends AbstractTableModel {
    /* Lista para armazenar os cabeçalhos da tabela */

    private Vector colunas;

    /* Lista para armazenar os dados da tabela */
    private Vector linhas;

    public RuaTableModel() {
        /* Definição das colunas da tabela */
        colunas = new Vector();
        colunas.add("ID");
        colunas.add("Avenida");
        colunas.add("Avenida2");
        colunas.add("Peso");

        /* Definição dos dados da tabela */
        linhas = new Vector();
    }

    public int getRowCount() {
        /* Captura o total de linhas da tabela */
        int totalLinhas = linhas.size();

        /* Retorna o total de linhas */
        return totalLinhas;
    }

    public int getColumnCount() {
        /* Captura o total de colunas da tabela */
        int totalColunas = colunas.size();

        /* Retorna o total de colunas */
        return totalColunas;
    }

    public String getColumnName(int coluna) {
        /* Captura o nome da coluna */
        String nomeColuna = (String) colunas.get(coluna);

        /* Retorna o nome da coluna */
        return nomeColuna;
    }

    public Object getValueAt(int linha, int coluna) {
        /* Captura o registro informado */
        Vector registro = (Vector) linhas.get(linha);

        /* Dentro do registro captura a coluna selecionada */
        Object dado = registro.get(coluna);

        /* Retorna o valor capturado */
        return dado;
    }

    public void adicionar(Lista<Vertice> vertices) {
        /* Reinicializa os dados da tabela */
        linhas = new Vector();
        for (int i = 1; i <= vertices.getNelementos(); i++) {
        		Vertice v = vertices.obterPosição(i); // System.out.println(); }
        /* Percorre a lista copiando os dados para a tabela */
            /* Cria uma linha da tabela */
            Vector<Object> linha = new Vector<Object>();
            linha.add(v.getId());
            linha.add(v.getRuaHorizontal());
            linha.add(v.getRuaVertical());
            linha.add(v.getPeso());
            /* Adiciona a linha a tabela */
            linhas.add(linha);
        }
        /* Atualiza a tabela */
        fireTableDataChanged();
    }

}