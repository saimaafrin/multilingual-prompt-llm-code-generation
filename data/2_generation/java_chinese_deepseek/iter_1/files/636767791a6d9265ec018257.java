import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {

    /**
     * 添加日志记录消息以显示在 LogTable 中。此方法是线程安全的，因为它将请求发送到 SwingThread，而不是直接处理。
     */
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 在这里处理日志记录消息的添加逻辑
                // 例如，将日志记录添加到表格模型中
                // 假设有一个方法 addLogRecordToTableModel(LogRecord lr)
                addLogRecordToTableModel(lr);
            }
        });
    }

    // 假设的表格模型添加方法
    private void addLogRecordToTableModel(LogRecord lr) {
        // 实现将日志记录添加到表格模型的逻辑
        // 例如：
        // tableModel.addRow(new Object[]{lr.getLevel(), lr.getMessage()});
    }
}