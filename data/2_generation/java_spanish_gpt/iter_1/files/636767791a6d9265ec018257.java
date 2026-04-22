import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {

    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Aquí se agregaría el código para mostrar el mensaje en la LogTable
                // Por ejemplo, agregar el LogRecord a un modelo de tabla
                System.out.println("Log Message: " + lr.getMessage());
            }
        });
    }
}