import java.util.Set;

public class Graph<V> {

    /**
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Asumimos que el grafo tiene un método getIncomingEdges que devuelve las aristas entrantes
        // y un método getWeight que devuelve el peso de una arista.
        for (Edge<V> edge : getIncomingEdges(v)) {
            sum += edge.getWeight();
        }
        return sum;
    }

    // Métodos ficticios para completar la implementación
    private Set<Edge<V>> getIncomingEdges(Set<V> v) {
        // Implementación ficticia para obtener las aristas entrantes
        return Set.of();
    }

    private static class Edge<V> {
        private final double weight;

        public Edge(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }
    }
}