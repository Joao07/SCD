package tabela;

import dao.CursoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Curso;

public class TabelaCurso extends AbstractTableModel {

    private List<Curso> cursos;
    private final String[] colunas = {"ID", "Descrição", "Modúlos"};
    private CursoDAO CursoDAO;

    public TabelaCurso(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void addListaCurso(List<Curso> cursos1) {
        this.cursos = cursos1;
        fireTableDataChanged();
    }

    public void addCurso(Curso curso) {
        if (cursos == null) {
            cursos = new ArrayList<>();
        }
        this.cursos.add(curso);
        fireTableRowsInserted(getRowCount(), getRowCount() - 1);
        fireTableDataChanged();
    }

    public String delCurso(int indicde) {
        Curso curso = cursos.remove(indicde);
        fireTableRowsDeleted(indicde, indicde);
        return curso.getDescricao();
    }

    public void limparLista() {
        cursos.clear();
        fireTableDataChanged();

    }

    public TabelaCurso() {
        this.cursos = CursoDAO.getCurso();
    }

    @Override
    public int getRowCount() {
        return cursos.size();
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
        Curso curso = cursos.get(linha);
        switch (coluna) {
            case 0:
                return curso.getId();
            case 1:
                return curso.getDescricao();
            case 2:
                return curso.getQuantidadeModulos();
            default:
                return null;
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Curso get(int linha) {
        return cursos.get(linha);
    }
}
