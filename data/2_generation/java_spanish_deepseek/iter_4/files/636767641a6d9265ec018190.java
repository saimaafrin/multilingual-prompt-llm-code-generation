import java.util.List;
import java.util.Set;

private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
    // Obtener el cubo con la etiqueta mínima
    Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
    
    // Obtener el cubo con etiqueta 0
    Set<Integer> zeroLabelBucket = bucketsByLabel.get(0);
    
    // Mover todos los vértices del cubo con etiqueta minLabel al cubo con etiqueta 0
    zeroLabelBucket.addAll(minLabelBucket);
    
    // Limpiar el cubo con etiqueta minLabel
    minLabelBucket.clear();
    
    // Actualizar las etiquetas de los vértices movidos
    for (int vertex : zeroLabelBucket) {
        labels.set(vertex, 0);
    }
}