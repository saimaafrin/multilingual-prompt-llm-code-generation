import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {

    public void addMessage(final LogRecord lr) {
        // Ensure that the log message is processed on the Swing thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Here you would add the log record to your log table
                // For example, you might append it to a JTextArea or a JTable
                System.out.println("Log Message: " + lr.getMessage());
                // Additional code to update the LogTable UI can be added here
            }
        });
    }
}