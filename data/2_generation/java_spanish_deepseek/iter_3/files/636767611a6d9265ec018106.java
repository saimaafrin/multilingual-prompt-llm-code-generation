import java.util.Set;

public class Graph<V> {

    /**
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Asumimos que los pesos están almacenados en una estructura de datos accesible
        // como un mapa o una matriz de adyacencia. Aquí se simula la suma.
        for (V vertex : v) {
            // Aquí se debería obtener el peso asociado al vértice
            // sum += getWeight(vertex);
        }
        return sum;
    }
}