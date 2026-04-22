import java.util.Objects;

public class ClassFinder {

    /**
     * Trova la classe dato il nome della classe.
     * @param className nome della classe, non può essere nullo.
     * @return classe, non sarà nullo.
     * @throws ClassNotFoundException lanciata se la classe non può essere trovata.
     */
    private Class findClass(final String className) throws ClassNotFoundException {
        Objects.requireNonNull(className, "className cannot be null");
        
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Could not find class: " + className, e);
        }
    }
}