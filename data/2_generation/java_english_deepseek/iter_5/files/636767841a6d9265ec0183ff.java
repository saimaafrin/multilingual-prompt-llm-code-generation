import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class TableUtils {

    /**
     * Selects the specified row in the specified JTable and scrolls the specified JScrollPane to the newly selected row.
     * More importantly, the call to repaint() is delayed long enough to have the table properly paint the newly selected row which may be offscreen.
     * @param row The row index to select.
     * @param table The JTable to select the row in. Should belong to the specified JScrollPane.
     * @param pane The JScrollPane containing the JTable.
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null) {
            throw new IllegalArgumentException("Table and pane must not be null.");
        }

        TableModel model = table.getModel();
        if (row < 0 || row >= model.getRowCount()) {
            throw new IllegalArgumentException("Row index out of bounds.");
        }

        // Select the row
        table.setRowSelectionInterval(row, row);

        // Scroll to the selected row
        Rectangle cellRect = table.getCellRect(row, 0, true);
        table.scrollRectToVisible(cellRect);

        // Delay repaint to ensure proper rendering
        SwingUtilities.invokeLater(() -> {
            table.repaint();
            pane.repaint();
        });
    }
}