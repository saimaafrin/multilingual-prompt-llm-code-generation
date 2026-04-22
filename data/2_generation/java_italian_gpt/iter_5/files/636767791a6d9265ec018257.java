import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class Logger {
    
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Here you would add the log record to your LogTable
                // For demonstration, we will just print the message
                System.out.println(lr.getMessage());
            }
        });
    }
}