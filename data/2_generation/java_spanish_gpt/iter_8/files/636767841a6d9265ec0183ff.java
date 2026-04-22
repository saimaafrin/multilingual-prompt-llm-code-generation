import javax.swing.*;
import java.awt.*;

public class TableRowSelector {

    /** 
     * Selecciona la fila especificada en el JTable indicado y desplaza el JScrollPane especificado hacia la fila recién seleccionada. 
     * Más importante aún, la llamada a repaint() se retrasa lo suficiente para que la tabla pinte correctamente la fila recién seleccionada, que puede estar fuera de la pantalla.
     * @param row debe pertenecer al JScrollPane especificado
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table.getRowCount() > row && row >= 0) {
            table.setRowSelectionInterval(row, row);
            Rectangle rect = table.getCellRect(row, 0, true);
            table.scrollRectToVisible(rect);
            SwingUtilities.invokeLater(() -> {
                pane.repaint();
            });
        }
    }

    public static void main(String[] args) {
        // Example usage
        JFrame frame = new JFrame("Table Example");
        String[] columnNames = {"Column 1", "Column 2"};
        Object[][] data = {
            {"Data 1", "Data 2"},
            {"Data 3", "Data 4"},
            {"Data 5", "Data 6"},
            {"Data 7", "Data 8"},
            {"Data 9", "Data 10"},
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Select a row after a delay
        Timer timer = new Timer(1000, e -> selectRow(2, table, pane));
        timer.setRepeats(false);
        timer.start();
    }
}