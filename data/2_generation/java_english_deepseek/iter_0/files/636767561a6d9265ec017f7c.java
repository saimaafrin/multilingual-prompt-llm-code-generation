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

protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("Tour set cannot be empty.");
    }

    // Create a map to store the adjacency of vertices
    Map<V, V> adjacencyMap = new HashMap<>();
    for (E edge : tour) {
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);
        adjacencyMap.put(source, target);
    }

    // Find the starting vertex (a vertex with only one occurrence in the adjacency map)
    V startVertex = null;
    for (V vertex : adjacencyMap.keySet()) {
        if (!adjacencyMap.containsValue(vertex)) {
            startVertex = vertex;
            break;
        }
    }

    if (startVertex == null) {
        throw new IllegalArgumentException("Tour does not form a valid path.");
    }

    // Build the path
    List<E> edgeList = new ArrayList<>();
    V currentVertex = startVertex;
    while (adjacencyMap.containsKey(currentVertex)) {
        V nextVertex = adjacencyMap.get(currentVertex);
        E edge = graph.getEdge(currentVertex, nextVertex);
        if (edge == null) {
            throw new IllegalArgumentException("Edge not found in the graph.");
        }
        edgeList.add(edge);
        currentVertex = nextVertex;
    }

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, startVertex, currentVertex, edgeList, 0.0);
}