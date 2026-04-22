import javax.swing.*;
import java.util.logging.LogRecord;

public class LogTable {
    private final DefaultListModel<LogRecord> logListModel;

    public LogTable() {
        logListModel = new DefaultListModel<>();
    }

    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(() -> {
            logListModel.addElement(lr);
        });
    }

    public DefaultListModel<LogRecord> getLogListModel() {
        return logListModel;
    }

    public static void main(String[] args) {
        // Example usage
        LogTable logTable = new LogTable();
        LogRecord logRecord = new LogRecord(java.util.logging.Level.INFO, "Test log message");
        logTable.addMessage(logRecord);
    }
}