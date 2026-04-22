import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {

    /**
     * Aggiunge un messaggio di registrazione da visualizzare nella LogTable. Questo metodo è thread-safe in quanto invia le richieste al SwingThread anziché elaborarle direttamente.
     */
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Simula l'aggiunta del messaggio alla LogTable
                System.out.println("Log message added: " + lr.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        LogTable logTable = new LogTable();
        LogRecord logRecord = new LogRecord(java.util.logging.Level.INFO, "Test log message");
        logTable.addMessage(logRecord);
    }
}