import java.util.logging.Logger;

public class LoggerHierarchy {
    
    /**
     * Verifica si el registrador nombrado existe en la jerarquía. Si es así, devuelve su referencia; de lo contrario, devuelve <code>null</code>.
     * @param name El nombre del registrador que se busca.
     */
    public Logger exists(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        
        // Get the logger if it exists, without creating a new one
        return Logger.getLogger(name).getParent() == null ? null : Logger.getLogger(name);
    }
}