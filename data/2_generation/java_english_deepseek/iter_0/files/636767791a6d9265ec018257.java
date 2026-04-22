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
                // Assuming there is a method to add the log record to the table
                addLogRecordToTable(lr);
            }
        });
    }

    // Dummy method to represent adding a log record to the table
    private void addLogRecordToTable(LogRecord lr) {
        // Implementation to add the log record to the table
        System.out.println("LogRecord added: " + lr.getMessage());
    }
}