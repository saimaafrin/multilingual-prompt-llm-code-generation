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
        V start = graph.getEdgeSource(firstEdge);
        V current = graph.getEdgeTarget(firstEdge);

        // Initialize path components
        List<E> edges = new ArrayList<>();
        List<V> vertices = new ArrayList<>();
        edges.add(firstEdge);
        vertices.add(start);
        vertices.add(current);

        // Remove first edge from remaining edges to process
        Set<E> remainingEdges = new HashSet<>(tour);
        remainingEdges.remove(firstEdge);

        // Build path by connecting edges
        while (!remainingEdges.isEmpty()) {
            boolean found = false;
            for (E edge : remainingEdges) {
                if (graph.getEdgeSource(edge).equals(current)) {
                    current = graph.getEdgeTarget(edge);
                    edges.add(edge);
                    vertices.add(current);
                    remainingEdges.remove(edge);
                    found = true;
                    break;
                } else if (graph.getEdgeTarget(edge).equals(current)) {
                    current = graph.getEdgeSource(edge);
                    edges.add(edge);
                    vertices.add(current);
                    remainingEdges.remove(edge);
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Edges do not form a valid tour");
            }
        }

        // Calculate total weight
        double weight = edges.stream()
            .mapToDouble(graph::getEdgeWeight)
            .sum();

        return new GraphWalk<>(graph, vertices, weight);
    }
}