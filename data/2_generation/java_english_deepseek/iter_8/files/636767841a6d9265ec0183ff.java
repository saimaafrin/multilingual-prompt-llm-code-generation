import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import java.awt.Rectangle;

public class TableUtils {

    /**
     * Selects the specified row in the specified JTable and scrolls the specified JScrollPane to the newly selected row.
     * The call to repaint() is delayed long enough to have the table properly paint the newly selected row which may be offscreen.
     * @param row The row index to select.
     * @param table The JTable to select the row in. It should belong to the specified JScrollPane.
     * @param pane The JScrollPane containing the JTable.
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null) {
            throw new IllegalArgumentException("Table and ScrollPane must not be null.");
        }

        // Select the specified row
        table.setRowSelectionInterval(row, row);

        // Scroll to the selected row
        Rectangle cellRect = table.getCellRect(row, 0, true);
        JViewport viewport = pane.getViewport();
        Rectangle viewRect = viewport.getViewRect();

        // Calculate the new position to scroll to
        int y = cellRect.y;
        if (y < viewRect.y || y + cellRect.height > viewRect.y + viewRect.height) {
            viewport.setViewPosition(cellRect.getLocation());
        }

        // Delay the repaint to ensure the table properly paints the newly selected row
        table.repaint();
    }
}