import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

public class LogTable {
    private final List<LogRecord> logRecords;

    public LogTable() {
        logRecords = new ArrayList<>();
    }

    /** 
     * Add a log record message to be displayed in the LogTable. This method is thread-safe as it posts requests to the SwingThread rather than processing directly.
     */
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                logRecords.add(lr);
                // Here you would typically update the UI component that displays the log records
                // For example: updateLogTableUI();
            }
        });
    }

    // Placeholder for UI update method
    private void updateLogTableUI() {
        // Code to refresh the log table UI goes here
    }
}