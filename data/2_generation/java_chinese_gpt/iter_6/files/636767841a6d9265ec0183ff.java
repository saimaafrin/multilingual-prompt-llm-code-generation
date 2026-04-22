import javax.swing.*;
import java.awt.*;

public class TableRowSelector {

    /** 
     * 选择指定的 JTable 中的行，并将指定的 JScrollPane 滚动到新选择的行。更重要的是，调用 repaint() 的延迟足够长，以便表格能够正确绘制新选择的行，即使该行可能在当前视图之外。
     * @param row 应该属于指定的 JScrollPane
     * @param table 应该属于指定的 JScrollPane
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null || row < 0 || row >= table.getRowCount()) {
            throw new IllegalArgumentException("Invalid parameters");
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
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Select a row after the frame is visible
        SwingUtilities.invokeLater(() -> selectRow(2, table, pane));
    }
}