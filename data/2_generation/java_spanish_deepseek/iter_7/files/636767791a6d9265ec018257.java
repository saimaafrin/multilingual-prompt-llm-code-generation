import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {

    /**
     * Agrega un mensaje de registro a ser mostrado en la "LogTable". Este método es seguro para hilos ya que envía solicitudes al SwingThread en lugar de procesarlas directamente.
     */
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Aquí se agregaría el mensaje a la tabla de registro
                // Por ejemplo, podrías tener un método en la clase LogTable para agregar el registro
                // this.addLogRecord(lr);
                System.out.println("Mensaje de registro agregado: " + lr.getMessage());
            }
        });
    }

    // Método de ejemplo para agregar un registro a la tabla (no implementado)
    private void addLogRecord(LogRecord lr) {
        // Implementación para agregar el registro a la tabla
    }

    public static void main(String[] args) {
        LogTable logTable = new LogTable();
        LogRecord logRecord = new LogRecord(java.util.logging.Level.INFO, "Este es un mensaje de prueba");
        logTable.addMessage(logRecord);
    }
}