import java.util.Objects;

public class ClassFinder {

    /**
     * Encuentra la clase dada su nombre.
     * @param className nombre de la clase, no puede ser nulo.
     * @return clase, no será nula.
     * @throws ClassNotFoundException lanzada si no se puede encontrar la clase.
     */
    private Class<?> findClass(final String className) throws ClassNotFoundException {
        Objects.requireNonNull(className, "El nombre de la clase no puede ser nulo.");
        return Class.forName(className);
    }
}