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

        List<E> edges = new ArrayList<>();
        List<V> vertices = new ArrayList<>();
        
        // Get first edge and its vertices
        E firstEdge = tour.iterator().next();
        V start = graph.getEdgeSource(firstEdge);
        V current = graph.getEdgeTarget(firstEdge);
        
        edges.add(firstEdge);
        vertices.add(start);
        vertices.add(current);
        
        // Remove first edge from consideration
        Set<E> remaining = new HashSet<>(tour);
        remaining.remove(firstEdge);
        
        // Build path by connecting edges
        while (!remaining.isEmpty()) {
            boolean found = false;
            for (E edge : remaining) {
                V source = graph.getEdgeSource(edge);
                V target = graph.getEdgeTarget(edge);
                
                if (source.equals(current)) {
                    current = target;
                    found = true;
                } else if (target.equals(current)) {
                    current = source;
                    found = true;
                }
                
                if (found) {
                    edges.add(edge);
                    vertices.add(current);
                    remaining.remove(edge);
                    break;
                }
            }
            
            if (!found) {
                throw new IllegalArgumentException("Edge set does not form a valid tour");
            }
        }
        
        // Create and return graph path
        double weight = edges.stream()
            .mapToDouble(graph::getEdgeWeight)
            .sum();
            
        return new GraphWalk<>(graph, vertices, weight);
    }
}