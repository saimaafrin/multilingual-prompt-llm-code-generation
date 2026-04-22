import java.util.Set;

public class Graph<V> {

    /**
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Asumimos que los pesos están almacenados en un mapa o estructura similar
        // Aquí se debería implementar la lógica para sumar los pesos de las aristas que entran al vértice v
        // Por ejemplo:
        // for (Edge<V> edge : incomingEdges(v)) {
        //     sum += edge.getWeight();
        // }
        return sum;
    }

    // Método de ejemplo para obtener las aristas entrantes (debería ser implementado según la estructura del grafo)
    // private Set<Edge<V>> incomingEdges(V vertex) {
    //     // Lógica para obtener las aristas entrantes
    //     return new HashSet<>();
    // }
}