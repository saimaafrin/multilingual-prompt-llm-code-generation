import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("The tour set cannot be empty.");
    }

    // Create a map to store the adjacency list of the tour
    Map<V, List<V>> adjacencyMap = new HashMap<>();

    // Populate the adjacency map
    for (E edge : tour) {
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);

        adjacencyMap.computeIfAbsent(source, k -> new ArrayList<>()).add(target);
        adjacencyMap.computeIfAbsent(target, k -> new ArrayList<>()).add(source);
    }

    // Find the start vertex (a vertex with only one neighbor)
    V startVertex = null;
    for (Map.Entry<V, List<V>> entry : adjacencyMap.entrySet()) {
        if (entry.getValue().size() == 1) {
            startVertex = entry.getKey();
            break;
        }
    }

    if (startVertex == null) {
        throw new IllegalArgumentException("The tour does not form a valid path.");
    }

    // Build the path
    List<V> vertexList = new ArrayList<>();
    List<E> edgeList = new ArrayList<>();
    V currentVertex = startVertex;
    V previousVertex = null;

    while (true) {
        vertexList.add(currentVertex);
        List<V> neighbors = adjacencyMap.get(currentVertex);

        if (neighbors == null || neighbors.isEmpty()) {
            break;
        }

        V nextVertex = null;
        for (V neighbor : neighbors) {
            if (!neighbor.equals(previousVertex)) {
                nextVertex = neighbor;
                break;
            }
        }

        if (nextVertex == null) {
            break;
        }

        E edge = graph.getEdge(currentVertex, nextVertex);
        if (edge == null) {
            edge = graph.getEdge(nextVertex, currentVertex);
        }

        if (edge == null) {
            throw new IllegalArgumentException("The tour contains an edge not present in the graph.");
        }

        edgeList.add(edge);
        previousVertex = currentVertex;
        currentVertex = nextVertex;
    }

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, vertexList, edgeList, 0.0);
}