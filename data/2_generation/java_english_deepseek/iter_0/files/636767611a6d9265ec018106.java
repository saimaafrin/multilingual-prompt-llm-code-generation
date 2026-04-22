import java.util.Set;

public class GraphUtils {

    /**
     * Compute the sum of the weights entering a vertex
     * @param v the vertex
     * @return the sum of the weights entering a vertex
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        for (V vertex : v) {
            // Assuming V has a method getWeight() that returns the weight of the vertex
            sum += vertex.getWeight();
        }
        return sum;
    }
}