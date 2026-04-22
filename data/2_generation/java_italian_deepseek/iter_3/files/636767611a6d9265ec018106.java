import java.util.Set;

public class GraphUtils<V> {

    /**
     * Calcola la somma dei pesi che entrano in un vertice
     * @param v il vertice
     * @return la somma dei pesi che entrano in un vertice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Assuming that the graph is represented as a Map<V, Map<V, Double>> where the outer map
        // represents the source vertex and the inner map represents the destination vertex and the weight.
        // This is just a placeholder implementation, you would need to replace it with your actual graph representation.
        for (V source : v) {
            for (V destination : v) {
                // Assuming getWeight(source, destination) is a method that returns the weight of the edge
                // from source to destination. Replace this with your actual method or logic.
                double weight = getWeight(source, destination);
                sum += weight;
            }
        }
        return sum;
    }

    // Placeholder method for getting the weight between two vertices
    private double getWeight(V source, V destination) {
        // Replace this with your actual logic to get the weight
        return 0.0;
    }
}