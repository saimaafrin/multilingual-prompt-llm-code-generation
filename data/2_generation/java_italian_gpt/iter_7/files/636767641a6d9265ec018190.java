import java.util.List;
import java.util.Set;

public class BucketManager {

    /**
     * Sposta tutti i vertici dal bucket con etichetta {@code minLabel} al bucket con etichetta 0. 
     * Pulisce il bucket con etichetta {@code minLabel}. Aggiorna le etichette di conseguenza.
     * @param bucketsByLabel i buckets in cui sono memorizzati i vertici
     * @param labels le etichette dei vertici
     * @param minLabel il valore minimo del bucket non vuoto
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        // Controlla se il bucket con etichetta minLabel è vuoto
        if (bucketsByLabel.size() <= minLabel || bucketsByLabel.get(minLabel).isEmpty()) {
            return; // Non c'è nulla da spostare
        }

        // Ottieni il bucket con etichetta minLabel
        Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
        
        // Sposta i vertici dal bucket minLabel al bucket 0
        Set<Integer> zeroLabelBucket = bucketsByLabel.get(0);
        zeroLabelBucket.addAll(minLabelBucket);
        
        // Pulisci il bucket con etichetta minLabel
        minLabelBucket.clear();
        
        // Aggiorna le etichette dei vertici spostati
        for (Integer vertex : zeroLabelBucket) {
            labels.set(vertex, 0); // Aggiorna l'etichetta del vertice a 0
        }
    }
}