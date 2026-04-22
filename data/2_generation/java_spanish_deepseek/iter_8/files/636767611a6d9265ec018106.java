import java.util.Set;

public class GraphUtils {

    /**
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        for (V vertex : v) {
            // Assuming V has a method getIncomingWeight() that returns the weight of incoming edges
            sum += vertex.getIncomingWeight();
        }
        return sum;
    }
}