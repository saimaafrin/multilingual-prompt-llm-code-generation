import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogManager {
    private static final Logger LOGGER = Logger.getLogger(LogManager.class.getName());
    private LogTable logTable;

    public LogManager(LogTable logTable) {
        this.logTable = logTable;
    }

    /**
     * Add a log record message to be displayed in the LogTable. This method is thread-safe as it posts requests to the SwingThread rather than processing directly.
     * @param message The message to log
     */
    public void addLogRecord(final String message) {
        if (message == null || message.isEmpty()) {
            return;
        }

        // Post to Event Dispatch Thread to ensure thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    logTable.addRow(message);
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, "Error adding log record: " + e.getMessage(), e);
                }
            }
        });
    }
}

// Supporting class for compilation
class LogTable extends JTable {
    public void addRow(String message) {
        // Implementation details for adding row to table
    }
}