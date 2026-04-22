import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {

    /**
     * Add a log record message to be displayed in the LogTable. This method is thread-safe as it posts requests to the SwingThread rather than processing directly.
     */
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Assuming there is a method to update the table with the log record
                updateTable(lr);
            }
        });
    }

    private void updateTable(LogRecord lr) {
        // Implementation to update the table with the log record
        // This is a placeholder for the actual logic to update the table
        System.out.println("LogRecord added: " + lr.getMessage());
    }
}