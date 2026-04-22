import java.util.Set;

public class Graph<V> {

    /**
     * Calcola la somma dei pesi che entrano in un vertice
     * @param v il vertice
     * @return la somma dei pesi che entrano in un vertice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Supponiamo che il grafo sia rappresentato come una mappa di adiacenza con pesi
        // Map<V, Map<V, Double>> adjacencyMap;
        
        // Iteriamo su tutti i vertici del grafo
        for (V vertex : adjacencyMap.keySet()) {
            // Controlliamo se il vertice corrente ha un arco che punta a v
            if (adjacencyMap.get(vertex).containsKey(v)) {
                // Aggiungiamo il peso dell'arco alla somma
                sum += adjacencyMap.get(vertex).get(v);
            }
        }
        return sum;
    }

    // Esempio di mappa di adiacenza (dovrebbe essere inizializzata altrove)
    private Map<V, Map<V, Double>> adjacencyMap;

    // Costruttore per inizializzare la mappa di adiacenza
    public Graph(Map<V, Map<V, Double>> adjacencyMap) {
        this.adjacencyMap = adjacencyMap;
    }
}