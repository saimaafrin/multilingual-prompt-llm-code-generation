import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    // Create a list to store the vertices in the order of the tour
    List<V> vertexList = new ArrayList<>();
    E firstEdge = tour.iterator().next();
    V startVertex = graph.getEdgeSource(firstEdge);
    V currentVertex = startVertex;

    // Traverse the tour edges to build the vertex list
    while (!tour.isEmpty()) {
        vertexList.add(currentVertex);
        for (E edge : tour) {
            if (graph.getEdgeSource(edge).equals(currentVertex)) {
                currentVertex = graph.getEdgeTarget(edge);
                tour.remove(edge);
                break;
            } else if (graph.getEdgeTarget(edge).equals(currentVertex)) {
                currentVertex = graph.getEdgeSource(edge);
                tour.remove(edge);
                break;
            }
        }
    }

    // Ensure the path is closed by returning to the start vertex
    vertexList.add(startVertex);

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, vertexList, 0.0);
}