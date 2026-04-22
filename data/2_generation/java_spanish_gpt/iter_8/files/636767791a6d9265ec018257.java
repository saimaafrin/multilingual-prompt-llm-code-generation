import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {

    public void addMessage(final LogRecord lr) {
        // Ensure that the log message is processed on the Swing thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Here you would add the log record to your log table
                // For demonstration, we will just print the message
                System.out.println(lr.getMessage());
                // You can add code here to update your log table UI component
            }
        });
    }
}