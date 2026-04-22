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
            // Asumimos que el vértice tiene un método getIncomingWeight() que devuelve el peso de las aristas entrantes
            sum += vertex.getIncomingWeight();
        }
        return sum;
    }
}