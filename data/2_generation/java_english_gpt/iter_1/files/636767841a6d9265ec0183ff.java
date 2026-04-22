import javax.swing.*;
import java.awt.*;

public class TableRowSelector {

    /** 
     * Selects a the specified row in the specified JTable and scrolls the specified JScrollpane to the newly selected row. More importantly, the call to repaint() delayed long enough to have the table properly paint the newly selected row which may be offscreen.
     * @param row should belong to the specified JScrollPane
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
        frame.setSize(400, 300);

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
        
        frame.setVisible(true);

        // Select a row after the frame is visible
        SwingUtilities.invokeLater(() -> selectRow(2, table, pane));
    }
}