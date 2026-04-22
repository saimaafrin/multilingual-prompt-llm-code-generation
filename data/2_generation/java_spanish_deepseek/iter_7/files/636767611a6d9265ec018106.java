import java.util.Set;

public class GraphUtils<V> {

    /**
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Asumimos que el peso de cada vértice es 1.0 para este ejemplo.
        // En un caso real, deberías tener una forma de obtener el peso de cada vértice.
        for (V vertex : v) {
            sum += 1.0; // Aquí deberías sumar el peso real del vértice.
        }
        return sum;
    }
}