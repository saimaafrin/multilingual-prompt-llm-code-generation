import java.util.*;

public class LabelPropagation {
    
    /**
     * Mueve todos los vértices del cubo con etiqueta {@code minLabel} al cubo con etiqueta 0. 
     * Limpia el cubo con etiqueta {@code minLabel}. Actualiza el etiquetado en consecuencia.
     * @param bucketsByLabel los cubos donde se almacenan los vértices
     * @param labels las etiquetas de los vértices
     * @param minLabel el valor mínimo del cubo no vacío
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        // Obtener el conjunto de vértices del cubo minLabel
        Set<Integer> vertices = bucketsByLabel.get(minLabel);
        
        // Mover cada vértice al cubo 0
        for (Integer vertex : vertices) {
            // Actualizar la etiqueta del vértice a 0
            labels.set(vertex, 0);
            
            // Agregar el vértice al cubo 0
            bucketsByLabel.get(0).add(vertex);
        }
        
        // Limpiar el cubo minLabel
        bucketsByLabel.get(minLabel).clear();
    }
}