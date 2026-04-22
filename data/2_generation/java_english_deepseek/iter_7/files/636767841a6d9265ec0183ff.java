import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

public class TableUtils {

    /**
     * Selects the specified row in the specified JTable and scrolls the specified JScrollPane to the newly selected row.
     * The call to repaint() is delayed long enough to have the table properly paint the newly selected row which may be offscreen.
     * @param row The row index to select.
     * @param table The JTable to select the row in. Should belong to the specified JScrollPane.
     * @param pane The JScrollPane containing the JTable.
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null || row < 0 || row >= table.getRowCount()) {
            return;
        }

        // Select the row
        table.setRowSelectionInterval(row, row);

        // Scroll to the selected row
        JViewport viewport = pane.getViewport();
        if (viewport != null) {
            viewport.setViewPosition(table.getCellRect(row, 0, true).getLocation());

            // Delay the repaint to ensure the table properly paints the newly selected row
            SwingUtilities.invokeLater(() -> {
                table.repaint();
            });
        }
    }
}