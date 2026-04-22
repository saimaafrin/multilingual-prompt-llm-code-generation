import javax.swing.*;
import javax.swing.table.TableModel;

public class TableUtils {

    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null) {
            throw new IllegalArgumentException("Table and pane must not be null");
        }

        // Ensure the row is within the valid range
        TableModel model = table.getModel();
        if (row < 0 || row >= model.getRowCount()) {
            throw new IllegalArgumentException("Row index out of bounds");
        }

        // Select the specified row
        table.setRowSelectionInterval(row, row);

        // Scroll to the selected row
        table.scrollRectToVisible(table.getCellRect(row, 0, true));

        // Delay the repaint to ensure the table paints correctly
        SwingUtilities.invokeLater(() -> {
            table.repaint();
            pane.repaint();
        });
    }
}