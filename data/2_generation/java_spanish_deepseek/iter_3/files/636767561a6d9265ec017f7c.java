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

protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("The tour set cannot be empty.");
    }

    // Create a map to store the adjacency of vertices
    Map<V, V> adjacencyMap = new HashMap<>();
    for (E edge : tour) {
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);
        adjacencyMap.put(source, target);
    }

    // Start with any vertex in the tour
    V startVertex = adjacencyMap.keySet().iterator().next();
    List<V> vertexList = new ArrayList<>();
    vertexList.add(startVertex);

    // Traverse the tour to build the vertex list
    V currentVertex = startVertex;
    while (true) {
        V nextVertex = adjacencyMap.get(currentVertex);
        if (nextVertex == null || nextVertex.equals(startVertex)) {
            break;
        }
        vertexList.add(nextVertex);
        currentVertex = nextVertex;
    }

    // Create the edge list from the vertex list
    List<E> edgeList = new ArrayList<>();
    for (int i = 0; i < vertexList.size() - 1; i++) {
        V source = vertexList.get(i);
        V target = vertexList.get(i + 1);
        E edge = graph.getEdge(source, target);
        if (edge == null) {
            throw new IllegalArgumentException("The provided tour is not a valid path in the graph.");
        }
        edgeList.add(edge);
    }

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, startVertex, vertexList.get(vertexList.size() - 1), edgeList, 0.0);
}