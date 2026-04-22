import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {
    // Assuming LogTable has a method to add a log record to the table
    private void addLogRecordToTable(LogRecord lr) {
        // Implementation to add the log record to the table
    }

    public void addMessage(final LogRecord lr) {
        // Ensure the operation is performed on the Swing event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                addLogRecordToTable(lr);
            }
        });
    }
}