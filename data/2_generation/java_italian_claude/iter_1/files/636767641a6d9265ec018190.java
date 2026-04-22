import java.util.*;

public class BucketReloader {
    
    /**
     * Sposta tutti i vertici dal bucket con etichetta {@code minLabel} al bucket con etichetta 0. 
     * Pulisce il bucket con etichetta {@code minLabel}. Aggiorna le etichette di conseguenza.
     * @param bucketsByLabel i buckets in cui sono memorizzati i vertici
     * @param labels le etichette dei vertici 
     * @param minLabel il valore minimo del bucket non vuoto
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        Set<Integer> minBucket = bucketsByLabel.get(minLabel);
        Set<Integer> zeroBucket = bucketsByLabel.get(0);
        
        // Sposta tutti i vertici dal bucket minLabel al bucket 0
        for (Integer vertex : minBucket) {
            zeroBucket.add(vertex);
            labels.set(vertex, 0); // Aggiorna l'etichetta del vertice a 0
        }
        
        // Pulisce il bucket con etichetta minLabel
        minBucket.clear();
    }
}