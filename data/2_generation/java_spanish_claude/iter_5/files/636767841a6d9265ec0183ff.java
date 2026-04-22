import javax.swing.*;
import java.awt.*;
import javax.swing.table.TableModel;

public class TableUtils {

    /**
     * Selecciona la fila especificada en el JTable indicado y desplaza el JScrollPane especificado hacia la fila recién seleccionada. 
     * Más importante aún, la llamada a repaint() se retrasa lo suficiente para que la tabla pinte correctamente la fila recién seleccionada, 
     * que puede estar fuera de la pantalla.
     * @param table debe pertenecer al JScrollPane especificado
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (row < 0 || row >= table.getRowCount()) {
            return;
        }

        // Seleccionar la fila
        table.setRowSelectionInterval(row, row);

        // Calcular el rectángulo de la fila seleccionada
        Rectangle rect = table.getCellRect(row, 0, true);
        
        // Hacer scroll hasta la fila seleccionada
        pane.getViewport().setViewPosition(new Point(0, rect.y));

        // Retrasar el repaint para asegurar que la tabla se actualice correctamente
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                table.repaint();
            }
        });
    }
}