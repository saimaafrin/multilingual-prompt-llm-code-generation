import java.util.Set;

public class Graph<V> {
    private double[][] adjacencyMatrix; // Matriz de adyacencia para almacenar los pesos
    private V[] vertices; // Arreglo de vértices

    public Graph(double[][] adjacencyMatrix, V[] vertices) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.vertices = vertices;
    }

    /**
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        for (V vertex : v) {
            int index = getIndex(vertex);
            if (index != -1) {
                for (int i = 0; i < vertices.length; i++) {
                    sum += adjacencyMatrix[i][index];
                }
            }
        }
        return sum;
    }

    /**
     * Obtiene el índice de un vértice en el arreglo de vértices
     * @param vertex el vértice
     * @return el índice del vértice, o -1 si no se encuentra
     */
    private int getIndex(V vertex) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }
}