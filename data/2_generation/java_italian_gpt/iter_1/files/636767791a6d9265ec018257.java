import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class Logger {
    private final LogTable logTable;

    public Logger(LogTable logTable) {
        this.logTable = logTable;
    }

    /** 
     * Aggiunge un messaggio di registrazione da visualizzare nella LogTable. Questo metodo è thread-safe in quanto invia le richieste al SwingThread anziché elaborarle direttamente.
     */
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                logTable.addLogRecord(lr);
            }
        });
    }
}

class LogTable {
    public void addLogRecord(LogRecord lr) {
        // Implementation to add log record to the table
        System.out.println("Log Record Added: " + lr.getMessage());
    }
}