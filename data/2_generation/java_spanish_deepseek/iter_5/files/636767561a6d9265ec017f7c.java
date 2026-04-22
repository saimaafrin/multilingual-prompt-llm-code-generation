import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;

import java.util.*;

/**
 * Transforma una representación de conjunto en un camino de grafo.
 * @param tour un conjunto que contiene los bordes del recorrido
 * @param graph el grafo
 * @return un camino de grafo
 */
protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("El conjunto de bordes no puede estar vacío.");
    }

    // Crear una lista para almacenar los vértices del camino
    List<V> vertexList = new ArrayList<>();

    // Crear un mapa para almacenar los bordes y sus vértices de origen y destino
    Map<V, V> edgeMap = new HashMap<>();
    for (E edge : tour) {
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);
        edgeMap.put(source, target);
    }

    // Encontrar el vértice inicial (un vértice que no es destino de ningún borde)
    V startVertex = null;
    for (V vertex : edgeMap.keySet()) {
        if (!edgeMap.containsValue(vertex)) {
            startVertex = vertex;
            break;
        }
    }

    if (startVertex == null) {
        throw new IllegalArgumentException("El conjunto de bordes no forma un camino válido.");
    }

    // Construir la lista de vértices siguiendo los bordes
    V currentVertex = startVertex;
    while (currentVertex != null) {
        vertexList.add(currentVertex);
        currentVertex = edgeMap.get(currentVertex);
    }

    // Crear la lista de bordes en el orden correcto
    List<E> edgeList = new ArrayList<>();
    for (int i = 0; i < vertexList.size() - 1; i++) {
        V source = vertexList.get(i);
        V target = vertexList.get(i + 1);
        E edge = graph.getEdge(source, target);
        if (edge == null) {
            throw new IllegalArgumentException("El conjunto de bordes no forma un camino válido en el grafo.");
        }
        edgeList.add(edge);
    }

    // Crear y retornar el GraphPath
    return new DefaultGraphPath<>(graph, startVertex, vertexList.get(vertexList.size() - 1), edgeList, 0.0);
}