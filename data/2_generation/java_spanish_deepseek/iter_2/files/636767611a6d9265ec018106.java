import java.util.Set;

public class Graph<V> {

    /**
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Asumimos que los pesos están almacenados en una estructura de datos como un mapa
        // donde la clave es el vértice y el valor es el peso.
        // Este es un ejemplo genérico, la implementación real dependerá de cómo se almacenen los pesos.
        for (V vertex : v) {
            // Aquí se debería obtener el peso del vértice y sumarlo
            // sum += getWeight(vertex);
        }
        return sum;
    }

    // Método de ejemplo para obtener el peso de un vértice
    // private double getWeight(V vertex) {
    //     // Implementación para obtener el peso del vértice
    //     return 0.0; // Placeholder
    // }
}