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
                // 在这里添加将日志记录消息显示在 LogTable 中的逻辑
                // 例如：logTableModel.addLogRecord(lr);
            }
        });
    }
}