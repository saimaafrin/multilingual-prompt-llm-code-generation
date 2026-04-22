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

        // Make the row visible by scrolling to it
        Rectangle cellRect = table.getCellRect(row, 0, true);
        if (cellRect != null) {
            table.scrollRectToVisible(cellRect);
        }

        // Delay the repaint to ensure proper rendering
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Force a repaint of the table
                table.repaint();
                
                // Ensure the viewport is updated
                scrollPane.getViewport().revalidate();
                scrollPane.getViewport().repaint();
            }
        });
    }
}