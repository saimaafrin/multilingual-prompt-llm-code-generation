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
        
        tour.remove(firstEdge);
        
        // Build path by connecting edges
        while (!tour.isEmpty()) {
            boolean found = false;
            for (E edge : tour) {
                V source = graph.getEdgeSource(edge);
                V target = graph.getEdgeTarget(edge);
                
                if (source.equals(current)) {
                    edges.add(edge);
                    vertices.add(target);
                    current = target;
                    tour.remove(edge);
                    found = true;
                    break;
                } else if (target.equals(current)) {
                    edges.add(edge);
                    vertices.add(source);
                    current = source;
                    tour.remove(edge);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                throw new IllegalArgumentException("Invalid tour: edges do not form a continuous path");
            }
        }
        
        // Verify tour is complete (ends where it started)
        if (!current.equals(start)) {
            throw new IllegalArgumentException("Invalid tour: path does not return to start");
        }
        
        double weight = 0.0;
        for (E edge : edges) {
            weight += graph.getEdgeWeight(edge);
        }
        
        return new GraphWalk<>(graph, vertices, weight);
    }
}