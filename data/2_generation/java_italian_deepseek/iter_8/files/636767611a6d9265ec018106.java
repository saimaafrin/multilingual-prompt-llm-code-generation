import java.util.Set;

public class GraphUtils<V> {

    /**
     * Calcola la somma dei pesi che entrano in un vertice
     * @param v il vertice
     * @return la somma dei pesi che entrano in un vertice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Assuming that the weight is stored in a map or some other data structure
        // For example, if the weights are stored in a Map<V, Double> called weights:
        // for (V vertex : v) {
        //     sum += weights.getOrDefault(vertex, 0.0);
        // }
        // Since the actual implementation depends on how the weights are stored,
        // this is a placeholder implementation.
        return sum;
    }
}