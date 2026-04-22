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
    List<E> edgeList = new ArrayList<>(tour);

    // Start with the first edge in the set
    E firstEdge = edgeList.get(0);
    V startVertex = graph.getEdgeSource(firstEdge);
    V endVertex = graph.getEdgeTarget(firstEdge);

    // Add the start vertex
    vertexList.add(startVertex);

    // Traverse the edges to build the vertex list
    V currentVertex = startVertex;
    while (!edgeList.isEmpty()) {
        for (E edge : edgeList) {
            if (graph.getEdgeSource(edge).equals(currentVertex)) {
                vertexList.add(graph.getEdgeTarget(edge));
                currentVertex = graph.getEdgeTarget(edge);
                edgeList.remove(edge);
                break;
            } else if (graph.getEdgeTarget(edge).equals(currentVertex)) {
                vertexList.add(graph.getEdgeSource(edge));
                currentVertex = graph.getEdgeSource(edge);
                edgeList.remove(edge);
                break;
            }
        }
    }

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, vertexList, new ArrayList<>(tour));
}