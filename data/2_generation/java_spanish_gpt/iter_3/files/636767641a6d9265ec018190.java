import java.util.List;
import java.util.Set;

public class CubeMover {

    /**
     * Mueve todos los vértices del cubo con etiqueta {@code minLabel} al cubo con etiqueta 0. 
     * Limpia el cubo con etiqueta {@code minLabel}. Actualiza el etiquetado en consecuencia.
     * @param bucketsByLabel los cubos donde se almacenan los vértices
     * @param labels las etiquetas de los vértices
     * @param minLabel el valor mínimo del cubo no vacío
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        // Verifica que el cubo con minLabel no esté vacío
        if (minLabel < bucketsByLabel.size() && !bucketsByLabel.get(minLabel).isEmpty()) {
            Set<Integer> verticesToMove = bucketsByLabel.get(minLabel);
            Set<Integer> targetBucket = bucketsByLabel.get(0);

            // Mueve los vértices al cubo con etiqueta 0
            targetBucket.addAll(verticesToMove);

            // Limpia el cubo con etiqueta minLabel
            verticesToMove.clear();

            // Actualiza las etiquetas de los vértices movidos
            for (Integer vertex : targetBucket) {
                labels.set(vertex, 0);
            }
        }
    }
}