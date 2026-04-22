import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogManager {
    
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Assuming there's a method to display the log record in the LogTable
                displayLogRecord(lr);
            }
        });
    }

    private void displayLogRecord(LogRecord lr) {
        // Implementation to add the log record to the LogTable
        // This is a placeholder for the actual log display logic
        System.out.println("Log Message: " + lr.getMessage());
    }
}