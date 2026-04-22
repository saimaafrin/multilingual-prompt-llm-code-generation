import javax.swing.*;
import java.util.logging.LogRecord;

public class LogTable {
    private final DefaultListModel<String> logListModel;

    public LogTable(DefaultListModel<String> logListModel) {
        this.logListModel = logListModel;
    }

    public void addMessage(final LogRecord lr) {
        // Ensure the operation is performed on the Swing event dispatch thread
        SwingUtilities.invokeLater(() -> {
            String message = lr.getMessage();
            logListModel.addElement(message);
        });
    }
}