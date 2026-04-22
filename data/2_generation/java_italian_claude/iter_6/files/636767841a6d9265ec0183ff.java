import javax.swing.*;
import java.awt.*;

public class TableUtils {

    /**
     * Seleziona la riga specificata nella JTable specificata e scorre lo JScrollPane specificato fino alla riga appena selezionata. 
     * Più importante, la chiamata a repaint() è ritardata abbastanza a lungo da permettere alla tabella di dipingere correttamente 
     * la riga appena selezionata, che potrebbe essere fuori dallo schermo.
     * @param table deve appartenere allo JScrollPane specificato
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (row < 0 || row >= table.getRowCount()) {
            return;
        }

        // Seleziona la riga
        table.setRowSelectionInterval(row, row);

        // Calcola il rettangolo della riga selezionata
        Rectangle rect = table.getCellRect(row, 0, true);
        
        // Scorre fino alla riga selezionata
        table.scrollRectToVisible(rect);

        // Ritarda il repaint per assicurare che la selezione sia visibile
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Forza lo scroll
                pane.getViewport().scrollRectToVisible(rect);
                
                // Ritarda ulteriormente il repaint
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        table.repaint();
                    }
                });
            }
        });
    }
}