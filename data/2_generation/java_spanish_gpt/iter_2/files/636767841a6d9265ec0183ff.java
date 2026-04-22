import javax.swing.*;
import java.awt.*;

public class TableRowSelector {

    /** 
     * Selecciona la fila especificada en el JTable indicado y desplaza el JScrollPane especificado hacia la fila recién seleccionada. 
     * Más importante aún, la llamada a repaint() se retrasa lo suficiente para que la tabla pinte correctamente la fila recién seleccionada, que puede estar fuera de la pantalla.
     * @param row debe pertenecer al JScrollPane especificado
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null) {
            throw new IllegalArgumentException("Table and pane cannot be null");
        }
        
        if (row < 0 || row >= table.getRowCount()) {
            throw new IndexOutOfBoundsException("Row index is out of bounds");
        }

        // Select the specified row
        table.setRowSelectionInterval(row, row);
        
        // Scroll to the selected row
        SwingUtilities.invokeLater(() -> {
            Rectangle rect = table.getCellRect(row, 0, true);
            table.scrollRectToVisible(rect);
            pane.repaint();
        });
    }

    public static void main(String[] args) {
        // Sample usage
        JFrame frame = new JFrame("Table Row Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String[] columnNames = {"Column 1", "Column 2"};
        Object[][] data = {
            {"Row 1", "Data 1"},
            {"Row 2", "Data 2"},
            {"Row 3", "Data 3"},
            {"Row 4", "Data 4"},
            {"Row 5", "Data 5"},
        };
        
        JTable table = new JTable(data, columnNames);
        JScrollPane pane = new JScrollPane(table);
        
        frame.add(pane, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setVisible(true);
        
        // Select a row after a delay
        Timer timer = new Timer(1000, e -> selectRow(3, table, pane));
        timer.setRepeats(false);
        timer.start();
    }
}