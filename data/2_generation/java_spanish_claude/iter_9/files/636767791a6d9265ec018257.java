import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class Logger {
    private LogTable logTable;

    public Logger(LogTable logTable) {
        this.logTable = logTable;
    }

    /**
     * Agrega un mensaje de registro a ser mostrado en la "LogTable". Este método es seguro para hilos ya que envía solicitudes al SwingThread en lugar de procesarlas directamente.
     */
    public void addMessage(final LogRecord lr) {
        if (lr == null) {
            return;
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                logTable.addRow(lr);
            }
        });
    }
}

// Clase auxiliar LogTable asumida
class LogTable {
    public void addRow(LogRecord record) {
        // Implementación de agregar fila a la tabla
    }
}