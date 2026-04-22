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
            // Controlliamo se il vertice corrente ha archi che puntano a v
            if (adjacencyMap.get(vertex).containsKey(v)) {
                // Aggiungiamo il peso dell'arco alla somma
                sum += adjacencyMap.get(vertex).get(v);
            }
        }
        return sum;
    }

    // Supponiamo che il grafo sia rappresentato come una mappa di adiacenza con pesi
    private Map<V, Map<V, Double>> adjacencyMap;

    public Graph() {
        this.adjacencyMap = new HashMap<>();
    }

    // Metodo per aggiungere un arco con peso al grafo
    public void addEdge(V source, V destination, double weight) {
        adjacencyMap.computeIfAbsent(source, k -> new HashMap<>()).put(destination, weight);
    }

    // Metodo per aggiungere un vertice al grafo
    public void addVertex(V vertex) {
        adjacencyMap.putIfAbsent(vertex, new HashMap<>());
    }
}