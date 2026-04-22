import java.util.List;
import java.util.Set;

private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
    // Sposta tutti i vertici dal bucket con etichetta minLabel al bucket con etichetta 0
    Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
    Set<Integer> zeroLabelBucket = bucketsByLabel.get(0);
    
    zeroLabelBucket.addAll(minLabelBucket);
    minLabelBucket.clear();
    
    // Aggiorna le etichette dei vertici spostati
    for (int vertex : zeroLabelBucket) {
        labels.set(vertex, 0);
    }
}