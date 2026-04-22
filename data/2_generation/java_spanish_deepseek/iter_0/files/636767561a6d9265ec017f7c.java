import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Transforma una representación de conjunto en un camino de grafo.
 * @param tour un conjunto que contiene los bordes del recorrido
 * @param graph el grafo
 * @return un camino de grafo
 */
protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("El conjunto de bordes no puede estar vacío.");
    }

    // Crear un mapa para almacenar las conexiones entre vértices
    Map<V, V> vertexMap = new HashMap<>();
    for (E edge : tour) {
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);
        vertexMap.put(source, target);
    }

    // Encontrar el vértice inicial (un vértice que no es el destino de ningún borde)
    V startVertex = null;
    for (V vertex : vertexMap.keySet()) {
        if (!vertexMap.containsValue(vertex)) {
            startVertex = vertex;
            break;
        }
    }

    if (startVertex == null) {
        throw new IllegalArgumentException("El conjunto de bordes no forma un camino válido.");
    }

    // Construir la lista de vértices en el camino
    List<V> vertexList = new ArrayList<>();
    V currentVertex = startVertex;
    while (currentVertex != null) {
        vertexList.add(currentVertex);
        currentVertex = vertexMap.get(currentVertex);
    }

    // Construir la lista de bordes en el camino
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

    // Calcular el peso total del camino
    double weight = 0;
    for (E edge : edgeList) {
        weight += graph.getEdgeWeight(edge);
    }

    // Crear y retornar el GraphPath
    return new DefaultGraphPath<>(graph, startVertex, vertexList.get(vertexList.size() - 1), edgeList, weight);
}