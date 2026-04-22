import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class TableUtils {

    /**
     * Seleziona la riga specificata nella JTable specificata e scorre lo JScrollPane specificato fino alla riga appena selezionata. Più importante, la chiamata a repaint() è ritardata abbastanza a lungo da permettere alla tabella di dipingere correttamente la riga appena selezionata, che potrebbe essere fuori dallo schermo.
     * @param row l'indice della riga da selezionare
     * @param table deve appartenere allo JScrollPane specificato
     * @param pane lo JScrollPane che contiene la JTable
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (row < 0 || row >= table.getRowCount()) {
            throw new IllegalArgumentException("Row index out of bounds");
        }

        // Seleziona la riga specificata
        table.setRowSelectionInterval(row, row);

        // Scorri lo JScrollPane fino alla riga selezionata
        Rectangle cellRect = table.getCellRect(row, 0, true);
        table.scrollRectToVisible(cellRect);

        // Ritarda la chiamata a repaint() per permettere alla tabella di dipingere correttamente la riga selezionata
        SwingUtilities.invokeLater(() -> {
            table.repaint();
            pane.repaint();
        });
    }
}