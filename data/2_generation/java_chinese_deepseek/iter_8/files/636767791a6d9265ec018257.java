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
}