import java.lang.Class;

public class ClassFinder {
    
    /** 
     * Encuentra la clase dada su nombre.
     * @param className nombre de la clase, no puede ser nulo.
     * @return clase, no será nula.
     * @throws ClassNotFoundException lanzada si no se puede encontrar la clase.
     */
    private Class<?> findClass(final String className) throws ClassNotFoundException {
        if (className == null) {
            throw new IllegalArgumentException("El nombre de la clase no puede ser nulo.");
        }
        return Class.forName(className);
    }
    
    public static void main(String[] args) {
        ClassFinder finder = new ClassFinder();
        try {
            Class<?> clazz = finder.findClass("java.lang.String");
            System.out.println("Clase encontrada: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        }
    }
}