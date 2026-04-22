import java.util.List;
import java.util.Set;

public class CubeManager {

    /**
     * Mueve todos los vértices del cubo con etiqueta {@code minLabel} al cubo con etiqueta 0. Limpia el cubo con etiqueta {@code minLabel}. Actualiza el etiquetado en consecuencia.
     * @param bucketsByLabel los cubos donde se almacenan los vértices
     * @param labels las etiquetas de los vértices
     * @param minLabel el valor mínimo del cubo no vacío
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        // Verifica que el cubo con minLabel no esté vacío
        if (bucketsByLabel.size() <= minLabel || bucketsByLabel.get(minLabel).isEmpty()) {
            return; // No hay vértices que mover
        }

        // Mueve los vértices del cubo con minLabel al cubo con etiqueta 0
        Set<Integer> minLabelVertices = bucketsByLabel.get(minLabel);
        Set<Integer> zeroLabelVertices = bucketsByLabel.get(0);

        // Agrega todos los vértices del cubo minLabel al cubo 0
        zeroLabelVertices.addAll(minLabelVertices);

        // Limpia el cubo con etiqueta minLabel
        minLabelVertices.clear();

        // Actualiza las etiquetas de los vértices movidos
        for (Integer vertex : zeroLabelVertices) {
            labels.set(vertex, 0); // Asigna la etiqueta 0 a los vértices movidos
        }
    }
}