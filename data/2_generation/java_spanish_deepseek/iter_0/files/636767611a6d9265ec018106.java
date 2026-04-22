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
        // como un mapa o una matriz de adyacencia.
        // Aquí se debe implementar la lógica para sumar los pesos de las aristas que entran al vértice.
        // Por ejemplo, si tienes un mapa de adyacencia:
        // for (V neighbor : adjacencyMap.get(v)) {
        //     sum += getEdgeWeight(neighbor, v);
        // }
        return sum;
    }

    // Método de ejemplo para obtener el peso de una arista (debe ser implementado según la estructura del grafo)
    private double getEdgeWeight(V source, V target) {
        // Implementación de ejemplo
        return 0.0;
    }
}