import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import java.awt.Rectangle;

public class TableUtils {

    /**
     * Seleziona la riga specificata nella JTable specificata e scorre lo JScrollPane specificato fino alla riga appena selezionata. 
     * Più importante, la chiamata a repaint() è ritardata abbastanza a lungo da permettere alla tabella di dipingere correttamente la riga appena selezionata, che potrebbe essere fuori dallo schermo.
     * @param row l'indice della riga da selezionare
     * @param table deve appartenere allo JScrollPane specificato
     * @param pane lo JScrollPane che contiene la JTable
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        // Seleziona la riga specificata
        table.setRowSelectionInterval(row, row);

        // Ottiene il rettangolo che rappresenta la cella della riga selezionata
        Rectangle cellRect = table.getCellRect(row, 0, true);

        // Scorre lo JScrollPane fino a rendere visibile la riga selezionata
        JViewport viewport = pane.getViewport();
        Rectangle viewRect = viewport.getViewRect();
        cellRect.setLocation(cellRect.x - viewRect.x, cellRect.y - viewRect.y);
        viewport.scrollRectToVisible(cellRect);

        // Ritarda la chiamata a repaint() per permettere alla tabella di dipingere correttamente la riga selezionata
        try {
            Thread.sleep(100); // Ritardo di 100 millisecondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        table.repaint();
    }
}