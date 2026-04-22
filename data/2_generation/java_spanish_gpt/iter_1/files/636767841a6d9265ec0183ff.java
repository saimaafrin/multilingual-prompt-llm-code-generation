import javax.swing.*;
import java.awt.*;

public class TableRowSelector {

    /** 
     * Selecciona la fila especificada en el JTable indicado y desplaza el JScrollPane especificado hacia la fila recién seleccionada. 
     * Más importante aún, la llamada a repaint() se retrasa lo suficiente para que la tabla pinte correctamente la fila recién seleccionada, 
     * que puede estar fuera de la pantalla.
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
        JFrame frame = new JFrame("JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[][] data = {{"Row1", "Data1"}, {"Row2", "Data2"}, {"Row3", "Data3"}, {"Row4", "Data4"}};
        String[] columnNames = {"Column1", "Column2"};
        JTable table = new JTable(data, columnNames);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);

        // Example usage
        selectRow(2, table, pane);
    }
}