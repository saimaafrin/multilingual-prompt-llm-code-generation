import javax.swing.*;
import javax.swing.table.TableModel;

public class TableUtils {

    /**
     * Selecciona la fila especificada en el JTable indicado y desplaza el JScrollPane especificado hacia la fila recién seleccionada. Más importante aún, la llamada a repaint() se retrasa lo suficiente para que la tabla pinte correctamente la fila recién seleccionada, que puede estar fuera de la pantalla.
     * @param table debe pertenecer al JScrollPane especificado
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null) {
            throw new IllegalArgumentException("Table and pane must not be null");
        }

        TableModel model = table.getModel();
        if (row < 0 || row >= model.getRowCount()) {
            throw new IllegalArgumentException("Row index out of bounds");
        }

        // Selecciona la fila especificada
        table.setRowSelectionInterval(row, row);

        // Desplaza el JScrollPane hacia la fila seleccionada
        Rectangle cellRect = table.getCellRect(row, 0, true);
        table.scrollRectToVisible(cellRect);

        // Retrasa la llamada a repaint() para asegurar que la tabla pinte correctamente
        SwingUtilities.invokeLater(() -> {
            table.repaint();
        });
    }
}