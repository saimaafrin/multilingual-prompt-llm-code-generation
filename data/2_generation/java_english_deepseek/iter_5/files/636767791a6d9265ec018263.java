import java.util.Objects;

public class ClassFinder {

    /**
     * Find class given class name.
     * @param className class name, may not be null.
     * @return class, will not be null.
     * @throws ClassNotFoundException thrown if class can not be found.
     */
    private Class<?> findClass(final String className) throws ClassNotFoundException {
        Objects.requireNonNull(className, "Class name must not be null");
        return Class.forName(className);
    }
}