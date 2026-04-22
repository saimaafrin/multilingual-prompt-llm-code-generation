import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {

    /**
     * Devuelve el primer elemento en '<code>candidates</code>' que se encuentra en '<code>source</code>'. Si no hay ningún elemento en '<code>candidates</code>' presente en '<code>source</code>', devuelve <code>null</code>. El orden de iteración es específico de la implementación de {@link Collection}.
     * @param source la colección fuente
     * @param candidates los candidatos a buscar
     * @return el primer objeto presente, o <code>null</code> si no se encuentra
     */
    public static Object findFirstMatch(Collection source, Collection candidates) {
        if (source == null || candidates == null) {
            return null;
        }

        Iterator candidateIterator = candidates.iterator();
        while (candidateIterator.hasNext()) {
            Object candidate = candidateIterator.next();
            if (source.contains(candidate)) {
                return candidate;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Collection<String> source = java.util.List.of("apple", "banana", "cherry");
        Collection<String> candidates = java.util.List.of("banana", "grape", "cherry");

        Object result = findFirstMatch(source, candidates);
        System.out.println("Primer elemento encontrado: " + result); // Debería imprimir "banana"
    }
}