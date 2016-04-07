package tabela;

import dao.TurmaDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Turma;

public class TabelaTurma extends AbstractTableModel {

    private final List<Turma> turmas;
    private final String[] colunas = {"ID", "Descrição", "Turno"};
    private TurmaDAO TurmaDAO;

    public TabelaTurma(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public TabelaTurma() {
        this.turmas = TurmaDAO.getTurma();
    }

    @Override
    public int getRowCount() {
        return turmas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Turma turma = turmas.get(linha);
        switch (coluna) {
            case 0:
                return turma.getId();
            case 1:
                return turma.getDescricao();
            case 2:
                return turma.getTurno();

            default:
                return null;
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Turma get(int linha) {
        return turmas.get(linha);
    }
}
