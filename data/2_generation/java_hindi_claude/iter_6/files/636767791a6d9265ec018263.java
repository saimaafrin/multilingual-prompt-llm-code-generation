import java.lang.Class;

public class ClassFinder {

    /**
     * Find class given class name.
     * @param className class name, may not be null.
     * @return class, will not be null.
     * @throws ClassNotFoundException thrown if class can not be found.
     */
    public static Class<?> findClass(String className) throws ClassNotFoundException {
        if (className == null) {
            throw new IllegalArgumentException("Class name cannot be null");
        }
        
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Could not find class: " + className, e);
        }
    }
}