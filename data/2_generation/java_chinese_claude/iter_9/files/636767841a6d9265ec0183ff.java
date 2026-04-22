import javax.swing.*;
import java.awt.*;
import javax.swing.table.TableModel;

public class TableUtils {
    /**
     * 选择指定的 JTable 中的行，并将指定的 JScrollPane 滚动到新选择的行。更重要的是，调用 repaint() 的延迟足够长，以便表格能够正确绘制新选择的行，即使该行可能在当前视图之外。
     * @param table 应该属于指定的 JScrollPane
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null || row < 0 || row >= table.getRowCount()) {
            return;
        }

        // 选择指定行
        table.setRowSelectionInterval(row, row);

        // 计算要滚动到的矩形区域
        Rectangle rect = table.getCellRect(row, 0, true);
        
        // 滚动到指定区域
        table.scrollRectToVisible(rect);
        
        // 使用 SwingUtilities 确保在 EDT 中执行重绘
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 重新验证并重绘组件
                table.revalidate();
                table.repaint();
                
                // 额外延迟以确保正确绘制
                Timer timer = new Timer(100, e -> {
                    table.revalidate();
                    table.repaint();
                    pane.revalidate();
                    pane.repaint();
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
    }
}