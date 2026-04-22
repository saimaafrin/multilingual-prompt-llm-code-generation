import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;

import java.util.*;

/**
 * Transform from a Set representation to a graph path.
 * @param tour a set containing the edges of the tour
 * @param graph the graph
 * @return a graph path
 */
protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("Tour set cannot be empty.");
    }

    // Create a map to store the adjacency list of the tour
    Map<V, List<E>> adjacencyMap = new HashMap<>();
    for (E edge : tour) {
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);
        adjacencyMap.computeIfAbsent(source, k -> new ArrayList<>()).add(edge);
        adjacencyMap.computeIfAbsent(target, k -> new ArrayList<>()).add(edge);
    }

    // Find the starting vertex (a vertex with only one edge in the tour)
    V startVertex = null;
    for (Map.Entry<V, List<E>> entry : adjacencyMap.entrySet()) {
        if (entry.getValue().size() == 1) {
            startVertex = entry.getKey();
            break;
        }
    }

    if (startVertex == null) {
        throw new IllegalArgumentException("Tour does not form a valid path.");
    }

    // Build the path
    List<E> edgeList = new ArrayList<>();
    V currentVertex = startVertex;
    V previousVertex = null;

    while (edgeList.size() < tour.size()) {
        List<E> edges = adjacencyMap.get(currentVertex);
        for (E edge : edges) {
            V nextVertex = graph.getEdgeSource(edge).equals(currentVertex) ? graph.getEdgeTarget(edge) : graph.getEdgeSource(edge);
            if (!nextVertex.equals(previousVertex)) {
                edgeList.add(edge);
                previousVertex = currentVertex;
                currentVertex = nextVertex;
                break;
            }
        }
    }

    // Calculate the total weight of the path
    double weight = edgeList.stream().mapToDouble(graph::getEdgeWeight).sum();

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, startVertex, currentVertex, edgeList, weight);
}