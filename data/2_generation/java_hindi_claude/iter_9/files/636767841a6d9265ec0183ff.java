import javax.swing.*;
import java.awt.*;

public class TableUtils {
    /**
     * Selects a the specified row in the specified JTable and scrolls the specified JScrollpane to the newly selected row. 
     * More importantly, the call to repaint() delayed long enough to have the table properly paint the newly selected row which may be offscre
     * @param table should belong to the specified JScrollPane
     * @param scrollPane the scroll pane containing the table
     * @param row the row index to select and scroll to
     */
    public static void selectAndScrollToRow(JTable table, JScrollPane scrollPane, int row) {
        if (table == null || scrollPane == null || row < 0 || row >= table.getRowCount()) {
            return;
        }

        // Select the row
        table.setRowSelectionInterval(row, row);

        // Calculate rectangle of the row to scroll to
        Rectangle cellRect = table.getCellRect(row, 0, true);
        
        // Convert table coordinates to scrollpane coordinates
        Point p = SwingUtilities.convertPoint(table, cellRect.x, cellRect.y, 
                                            scrollPane.getViewport());
        cellRect.setLocation(p);

        // Scroll to make the rectangle visible
        scrollPane.getViewport().scrollRectToVisible(cellRect);
        
        // Add small delay before repainting to ensure proper rendering
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // Ignore interruption
                }
                table.repaint();
            }
        });
    }
}