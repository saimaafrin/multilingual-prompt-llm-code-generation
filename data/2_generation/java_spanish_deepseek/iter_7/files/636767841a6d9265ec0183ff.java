import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class TableUtils {

    /**
     * Selecciona la fila especificada en el JTable indicado y desplaza el JScrollPane especificado hacia la fila recién seleccionada. Más importante aún, la llamada a repaint() se retrasa lo suficiente para que la tabla pinte correctamente la fila recién seleccionada, que puede estar fuera de la pantalla.
     * @param table debe pertenecer al JScrollPane especificado
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (row >= 0 && row < table.getRowCount()) {
            table.setRowSelectionInterval(row, row);
            table.scrollRectToVisible(table.getCellRect(row, 0, true));

            // Retrasar la llamada a repaint para asegurar que la fila se pinte correctamente
            SwingUtilities.invokeLater(() -> {
                pane.repaint();
            });
        }
    }
}