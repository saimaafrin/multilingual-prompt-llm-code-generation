import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {
    
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Here you would add the log record to your log table
                // For example, you might add it to a model that backs a JTable
                System.out.println("Log message added: " + lr.getMessage());
                // Add your logic to update the LogTable UI component
            }
        });
    }
}