import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogManager {
    
    /**
     * 添加日志记录消息以显示在 LogTable 中。此方法是线程安全的，因为它将请求发送到 SwingThread，而不是直接处理。
     */
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 假设有一个方法来更新 LogTable
                updateLogTable(lr);
            }
        });
    }

    private void updateLogTable(LogRecord lr) {
        // 这里实现更新 LogTable 的逻辑
        System.out.println("Log Message: " + lr.getMessage());
    }
}