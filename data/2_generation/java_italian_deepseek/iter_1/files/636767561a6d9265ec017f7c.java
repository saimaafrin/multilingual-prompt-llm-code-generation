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
        throw new IllegalArgumentException("The tour does not form a valid path.");
    }

    // Build the vertex list for the path
    List<V> vertexList = new ArrayList<>();
    vertexList.add(startVertex);
    V currentVertex = startVertex;
    while (adjacencyMap.containsKey(currentVertex)) {
        currentVertex = adjacencyMap.get(currentVertex);
        vertexList.add(currentVertex);
    }

    // Build the edge list for the path
    List<E> edgeList = new ArrayList<>();
    for (int i = 0; i < vertexList.size() - 1; i++) {
        V source = vertexList.get(i);
        V target = vertexList.get(i + 1);
        E edge = graph.getEdge(source, target);
        if (edge == null) {
            throw new IllegalArgumentException("The tour contains edges not present in the graph.");
        }
        edgeList.add(edge);
    }

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, vertexList, edgeList, 0.0);
}