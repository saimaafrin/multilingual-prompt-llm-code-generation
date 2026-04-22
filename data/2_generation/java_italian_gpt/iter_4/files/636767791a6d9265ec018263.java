import java.lang.Class;

public class ClassFinder {
    
    /** 
     * Trova la classe dato il nome della classe.
     * @param className nome della classe, non può essere nullo.
     * @return classe, non sarà nullo.
     * @throws ClassNotFoundException lanciata se la classe non può essere trovata.
     */
    private Class<?> findClass(final String className) throws ClassNotFoundException {
        if (className == null) {
            throw new IllegalArgumentException("className cannot be null");
        }
        return Class.forName(className);
    }
    
    public static void main(String[] args) {
        ClassFinder finder = new ClassFinder();
        try {
            Class<?> clazz = finder.findClass("java.lang.String");
            System.out.println("Class found: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
    }
}