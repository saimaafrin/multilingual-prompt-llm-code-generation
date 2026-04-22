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

        List<E> edges = new ArrayList<>(tour);
        List<V> vertices = new ArrayList<>();
        
        // Get first vertex
        V start = graph.getEdgeSource(edges.get(0));
        vertices.add(start);
        
        V current = graph.getEdgeTarget(edges.get(0));
        vertices.add(current);
        
        // Remove first edge since it's processed
        edges.remove(0);
        
        // Build path by following edges
        while (!edges.isEmpty()) {
            for (Iterator<E> it = edges.iterator(); it.hasNext();) {
                E edge = it.next();
                V source = graph.getEdgeSource(edge);
                V target = graph.getEdgeTarget(edge);
                
                if (source.equals(current)) {
                    current = target;
                    vertices.add(current);
                    it.remove();
                    break;
                } else if (target.equals(current)) {
                    current = source;
                    vertices.add(current);
                    it.remove();
                    break;
                }
            }
        }
        
        // Calculate total weight of path
        double weight = 0.0;
        for (E edge : tour) {
            weight += graph.getEdgeWeight(edge);
        }
        
        return new GraphWalk<>(graph, vertices, weight);
    }
}