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
        
        // 使用SwingUtilities.invokeLater确保UI更新
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 重新验证并重绘组件
                pane.validate();
                table.repaint();
                
                // 额外延迟以确保正确绘制
                Timer timer = new Timer(100, e -> {
                    table.repaint();
                    ((Timer)e.getSource()).stop();
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
    }
}