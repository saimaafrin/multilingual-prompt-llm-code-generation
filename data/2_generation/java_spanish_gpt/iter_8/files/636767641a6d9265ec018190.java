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
        if (minLabel < 0 || minLabel >= bucketsByLabel.size()) {
            throw new IllegalArgumentException("minLabel is out of bounds");
        }

        Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
        Set<Integer> zeroLabelBucket = bucketsByLabel.get(0);

        // Mover todos los vértices del cubo con etiqueta minLabel al cubo con etiqueta 0
        for (Integer vertex : minLabelBucket) {
            zeroLabelBucket.add(vertex);
            labels.set(vertex, 0); // Actualizar la etiqueta del vértice
        }

        // Limpiar el cubo con etiqueta minLabel
        minLabelBucket.clear();
    }
}