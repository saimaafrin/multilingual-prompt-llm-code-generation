import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {

    /**
     * Add a log record message to be displayed in the LogTable. This method is thread-safe as it posts requests to the SwingThread rather than processing directly.
     */
    public void addMessage(final LogRecord lr) {
        // Ensure the operation is performed on the Swing event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Add the log record to the table model or perform any other UI updates
                // For example:
                // logTableModel.addLogRecord(lr);
                System.out.println("LogRecord added: " + lr.getMessage());
            }
        });
    }
}