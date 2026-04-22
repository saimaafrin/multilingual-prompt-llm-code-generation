import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

public class TableUtils {

    /**
     * Selects the specified row in the specified JTable and scrolls the specified JScrollPane to the newly selected row.
     * More importantly, the call to repaint() is delayed long enough to have the table properly paint the newly selected row which may be offscreen.
     * @param row The row index to select.
     * @param table The JTable to select the row in. Should belong to the specified JScrollPane.
     * @param pane The JScrollPane containing the JTable.
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (row >= 0 && row < table.getRowCount()) {
            table.setRowSelectionInterval(row, row);
            table.scrollRectToVisible(table.getCellRect(row, 0, true));

            // Delay the repaint to ensure the table properly paints the newly selected row
            SwingUtilities.invokeLater(() -> {
                JViewport viewport = pane.getViewport();
                if (viewport != null) {
                    viewport.repaint();
                }
            });
        }
    }
}