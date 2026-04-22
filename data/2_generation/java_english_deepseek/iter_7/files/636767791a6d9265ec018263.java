import java.lang.Class;
import java.lang.ClassNotFoundException;

public class ClassFinder {

    /**
     * Find class given class name.
     * @param className class name, may not be null.
     * @return class, will not be null.
     * @throws ClassNotFoundException thrown if class can not be found.
     */
    private Class<?> findClass(final String className) throws ClassNotFoundException {
        if (className == null) {
            throw new IllegalArgumentException("Class name cannot be null.");
        }
        return Class.forName(className);
    }
}