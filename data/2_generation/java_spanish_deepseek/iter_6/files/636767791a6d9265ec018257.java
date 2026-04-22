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
                // Aquí se puede agregar la lógica para actualizar la tabla de registros
                // Por ejemplo, agregar el LogRecord a un modelo de tabla y notificar a la vista
                System.out.println("LogRecord agregado: " + lr.getMessage());
            }
        });
    }
}