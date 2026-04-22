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
 * एक सेट प्रतिनिधित्व से एक ग्राफ पथ में परिवर्तन करें।
 * @param tour एक सेट जो यात्रा के किनारों को शामिल करता है
 * @param graph ग्राफ
 * @return एक ग्राफ पथ
 */
protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("Tour cannot be empty.");
    }

    // Create a map to store the adjacency of vertices
    Map<V, V> adjacencyMap = new HashMap<>();
    for (E edge : tour) {
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);
        adjacencyMap.put(source, target);
    }

    // Find the starting vertex
    V startVertex = adjacencyMap.keySet().iterator().next();
    V currentVertex = startVertex;
    List<V> vertexList = new ArrayList<>();
    List<E> edgeList = new ArrayList<>();

    // Traverse the tour
    do {
        vertexList.add(currentVertex);
        V nextVertex = adjacencyMap.get(currentVertex);
        E edge = graph.getEdge(currentVertex, nextVertex);
        edgeList.add(edge);
        currentVertex = nextVertex;
    } while (!currentVertex.equals(startVertex));

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, startVertex, startVertex, vertexList, edgeList);
}