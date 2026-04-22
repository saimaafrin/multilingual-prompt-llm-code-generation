import java.util.Collection;
import java.util.Arrays;

public class CollectionConverter {
    
    /** 
     * Convierte la colección dada en un arreglo de Strings. El arreglo devuelto no contiene entradas <code>null</code>. Tenga en cuenta que {@link Arrays#sort(Object[])} lanzará una {@link NullPointerException} si un elemento del arreglo es <code>null</code>.
     * @param collection La colección a convertir
     * @return Un nuevo arreglo de Strings.
     */
    static String[] toNoNullStringArray(Collection<?> collection) {
        if (collection == null) {
            return new String[0];
        }
        
        return collection.stream()
                         .filter(item -> item != null)
                         .map(Object::toString)
                         .toArray(String[]::new);
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso
        Collection<Object> collection = Arrays.asList("Hello", null, "World", 123);
        String[] result = toNoNullStringArray(collection);
        System.out.println(Arrays.toString(result)); // Salida: [Hello, World, 123]
    }
}