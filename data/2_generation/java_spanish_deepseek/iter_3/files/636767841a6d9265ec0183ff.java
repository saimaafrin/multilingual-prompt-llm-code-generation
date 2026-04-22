import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

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

        // Selecciona la fila
        table.setRowSelectionInterval(row, row);

        // Asegura que la fila seleccionada esté visible
        Rectangle cellRect = table.getCellRect(row, 0, true);
        table.scrollRectToVisible(cellRect);

        // Retrasa el repaint para asegurar que la tabla se pinte correctamente
        SwingUtilities.invokeLater(() -> {
            pane.repaint();
            table.repaint();
        });
    }
}