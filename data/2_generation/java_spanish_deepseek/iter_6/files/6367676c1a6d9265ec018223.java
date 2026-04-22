import java.util.Collection;

public class CollectionUtils {

    /**
     * Verifica si la colección dada contiene la instancia del elemento proporcionado. <p>Exige que la instancia dada esté presente, en lugar de devolver <code>true</code> para un elemento igual también.
     * @param collection la colección a verificar
     * @param element el elemento a buscar
     * @return <code>true</code> si se encuentra, <code>false</code> en caso contrario
     */
    public static boolean containsInstance(Collection<?> collection, Object element) {
        if (collection == null || element == null) {
            return false;
        }
        for (Object item : collection) {
            if (item == element) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Collection<String> collection = new java.util.ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");

        String element = "B";
        System.out.println(containsInstance(collection, element)); // true

        String newElement = new String("B");
        System.out.println(containsInstance(collection, newElement)); // false
    }
}