import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class Logger {
    private LogTable logTable; // Assume LogTable is defined elsewhere
    
    /**
     * Aggiunge un messaggio di registrazione da visualizzare nella LogTable. 
     * Questo metodo è thread-safe in quanto invia le richieste al SwingThread anziché elaborarle direttamente.
     */
    public void addMessage(final LogRecord lr) {
        if (lr == null) {
            return;
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    logTable.addLogRecord(lr);
                } catch (Exception e) {
                    System.err.println("Error adding log record: " + e.getMessage());
                }
            }
        });
    }
}