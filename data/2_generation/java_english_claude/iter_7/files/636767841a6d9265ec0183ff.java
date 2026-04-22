import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.Rectangle;

public class TableUtils {
    /**
     * Selects a the specified row in the specified JTable and scrolls the specified JScrollpane 
     * to the newly selected row. More importantly, the call to repaint() delayed long enough to 
     * have the table properly paint the newly selected row which may be offscreen
     * @param table should belong to the specified JScrollPane
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (row < 0 || row >= table.getRowCount()) {
            return;
        }

        // Select the row
        table.setRowSelectionInterval(row, row);

        // Get the rectangle for the cell
        Rectangle rect = table.getCellRect(row, 0, true);
        
        // Convert table coordinates to scroll pane coordinates
        rect = SwingUtilities.convertRectangle(table, rect, pane.getViewport());
        
        // Scroll to make the rectangle visible
        pane.getViewport().scrollRectToVisible(rect);
        
        // Schedule a repaint to ensure proper rendering
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                table.repaint();
            }
        });
    }
}