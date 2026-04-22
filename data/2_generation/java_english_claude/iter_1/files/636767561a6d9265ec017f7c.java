import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.GraphWalk;
import java.util.*;

public class TourTransformer<V,E> {

    /**
     * Transform from a Set representation to a graph path.
     * @param tour a set containing the edges of the tour
     * @param graph the graph
     * @return a graph path
     */
    protected GraphPath<V,E> edgeSetToTour(Set<E> tour, Graph<V,E> graph) {
        if (tour.isEmpty()) {
            return null;
        }

        // Get first edge and its vertices
        E firstEdge = tour.iterator().next();
        V startVertex = graph.getEdgeSource(firstEdge);
        V currentVertex = graph.getEdgeTarget(firstEdge);

        // Initialize path components
        List<E> edges = new ArrayList<>();
        List<V> vertices = new ArrayList<>();
        edges.add(firstEdge);
        vertices.add(startVertex);
        vertices.add(currentVertex);

        // Remove first edge from remaining edges to process
        Set<E> remainingEdges = new HashSet<>(tour);
        remainingEdges.remove(firstEdge);

        // Build path by connecting edges
        while (!remainingEdges.isEmpty()) {
            boolean found = false;
            for (E edge : remainingEdges) {
                V source = graph.getEdgeSource(edge);
                V target = graph.getEdgeTarget(edge);

                if (source.equals(currentVertex)) {
                    edges.add(edge);
                    vertices.add(target);
                    currentVertex = target;
                    remainingEdges.remove(edge);
                    found = true;
                    break;
                } else if (target.equals(currentVertex)) {
                    edges.add(edge);
                    vertices.add(source);
                    currentVertex = source;
                    remainingEdges.remove(edge);
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new IllegalArgumentException("Edge set does not form a valid tour");
            }
        }

        // Verify tour is complete (ends at start vertex)
        if (!currentVertex.equals(startVertex)) {
            throw new IllegalArgumentException("Edge set does not form a complete tour");
        }

        // Calculate total weight of tour
        double weight = edges.stream()
            .mapToDouble(graph::getEdgeWeight)
            .sum();

        return new GraphWalk<>(graph, vertices, weight);
    }
}