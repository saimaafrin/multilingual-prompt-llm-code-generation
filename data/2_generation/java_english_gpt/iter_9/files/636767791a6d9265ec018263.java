import java.util.Objects;

public class ClassFinder {

    /** 
     * Find class given class name.
     * @param className class name, may not be null.
     * @return class, will not be null.
     * @throws ClassNotFoundException thrown if class can not be found.
     */
    private Class<?> findClass(final String className) throws ClassNotFoundException {
        Objects.requireNonNull(className, "className must not be null");
        return Class.forName(className);
    }

    public static void main(String[] args) {
        ClassFinder classFinder = new ClassFinder();
        try {
            Class<?> clazz = classFinder.findClass("java.lang.String");
            System.out.println("Class found: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
    }
}