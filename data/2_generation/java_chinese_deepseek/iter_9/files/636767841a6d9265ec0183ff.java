import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class TableUtils {

    /**
     * 选择指定的 JTable 中的行，并将指定的 JScrollPane 滚动到新选择的行。更重要的是，调用 repaint() 的延迟足够长，以便表格能够正确绘制新选择的行，即使该行可能在当前视图之外。
     * @param row 要选择的行索引
     * @param table 应该属于指定的 JScrollPane
     * @param pane 包含 JTable 的 JScrollPane
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null) {
            throw new IllegalArgumentException("Table and ScrollPane must not be null");
        }

        TableModel model = table.getModel();
        if (row < 0 || row >= model.getRowCount()) {
            throw new IllegalArgumentException("Row index out of bounds");
        }

        // 选择指定的行
        table.setRowSelectionInterval(row, row);

        // 确保表格滚动到选中的行
        Rectangle cellRect = table.getCellRect(row, 0, true);
        table.scrollRectToVisible(cellRect);

        // 延迟调用 repaint() 以确保表格正确绘制
        SwingUtilities.invokeLater(() -> {
            table.repaint();
            pane.repaint();
        });
    }

    public static void main(String[] args) {
        // 示例用法
        JFrame frame = new JFrame("Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        String[] columnNames = {"Column 1", "Column 2", "Column 3"};
        Object[][] data = {
                {"1", "A", "X"},
                {"2", "B", "Y"},
                {"3", "C", "Z"},
                {"4", "D", "W"},
                {"5", "E", "V"}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setVisible(true);

        // 选择第3行并滚动到该行
        selectRow(2, table, scrollPane);
    }
}