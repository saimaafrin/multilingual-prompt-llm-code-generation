import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {
    
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Code to add the log record to the LogTable
                // For example, you might want to append it to a JTextArea or a JTable
                System.out.println("Log Message: " + lr.getMessage());
            }
        });
    }
}