import javax.swing.*;
import java.awt.*;

public class TableRowSelector {

    /** 
     * Selects a the specified row in the specified JTable and scrolls the specified JScrollpane to the newly selected row. More importantly, the call to repaint() delayed long enough to have the table properly paint the newly selected row which may be offscreen.
     * @param row should belong to the specified JTable
     * @param table should belong to the specified JScrollPane
     * @param pane the JScrollPane containing the JTable
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null) {
            throw new IllegalArgumentException("Table and JScrollPane cannot be null");
        }
        
        if (row < 0 || row >= table.getRowCount()) {
            throw new IndexOutOfBoundsException("Row index is out of bounds");
        }

        // Select the specified row
        table.setRowSelectionInterval(row, row);
        
        // Scroll to the selected row
        Rectangle rect = table.getCellRect(row, 0, true);
        table.scrollRectToVisible(rect);
        
        // Delay repaint to ensure the row is painted properly
        SwingUtilities.invokeLater(() -> {
            table.repaint();
        });
    }

    public static void main(String[] args) {
        // Sample usage
        JFrame frame = new JFrame("Table Row Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames = {"Column 1", "Column 2"};
        Object[][] data = {
            {"Data 1", "Data 2"},
            {"Data 3", "Data 4"},
            {"Data 5", "Data 6"},
            {"Data 7", "Data 8"},
            {"Data 9", "Data 10"}
        };
        JTable table = new JTable(data, columnNames);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setVisible(true);

        // Select a row after a delay
        Timer timer = new Timer(1000, e -> selectRow(2, table, pane));
        timer.setRepeats(false);
        timer.start();
    }
}