import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class Logger {
    private LogTable logTable; // Assuming LogTable is a class that handles the display of log messages

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
                logTable.addLogRecord(lr); // Assuming addLogRecord is a method in LogTable to add the log record
            }
        });
    }
}

// Assuming a simple LogTable class for demonstration purposes
class LogTable {
    public void addLogRecord(LogRecord lr) {
        // Logic to add the log record to the table
        System.out.println("Log added: " + lr.getMessage());
    }
}