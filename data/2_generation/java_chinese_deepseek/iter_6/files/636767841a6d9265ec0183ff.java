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

        // 获取行的矩形区域
        Rectangle cellRect = table.getCellRect(row, 0, true);

        // 将 JScrollPane 滚动到该行的位置
        pane.getViewport().scrollRectToVisible(cellRect);

        // 延迟调用 repaint() 以确保表格正确绘制新选择的行
        SwingUtilities.invokeLater(() -> {
            table.repaint();
        });
    }
}