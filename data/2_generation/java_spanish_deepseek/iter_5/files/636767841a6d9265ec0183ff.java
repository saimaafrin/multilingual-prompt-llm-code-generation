import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class TableUtils {

    /**
     * Selecciona la fila especificada en el JTable indicado y desplaza el JScrollPane especificado hacia la fila recién seleccionada. Más importante aún, la llamada a repaint() se retrasa lo suficiente para que la tabla pinte correctamente la fila recién seleccionada, que puede estar fuera de la pantalla.
     * @param row la fila a seleccionar
     * @param table debe pertenecer al JScrollPane especificado
     * @param pane el JScrollPane que contiene la tabla
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null) {
            throw new IllegalArgumentException("Table and pane must not be null");
        }

        // Selecciona la fila especificada
        table.setRowSelectionInterval(row, row);

        // Desplaza el JScrollPane hacia la fila seleccionada
        table.scrollRectToVisible(table.getCellRect(row, 0, true));

        // Retrasa la llamada a repaint para asegurar que la tabla pinte correctamente
        SwingUtilities.invokeLater(() -> {
            table.repaint();
        });
    }
}