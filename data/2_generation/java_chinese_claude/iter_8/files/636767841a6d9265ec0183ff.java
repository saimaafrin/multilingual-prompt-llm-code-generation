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
        
        // 使用SwingUtilities.invokeLater确保在EDT线程中执行重绘
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 重新验证并重绘组件
                table.revalidate();
                table.repaint();
                
                // 确保滚动面板也更新
                pane.revalidate();
                pane.repaint();
            }
        });

        // 添加额外的延迟重绘以确保正确显示
        Timer timer = new Timer(100, e -> {
            table.revalidate();
            table.repaint();
            ((Timer)e.getSource()).stop();
        });
        timer.setRepeats(false);
        timer.start();
    }
}