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

        // Create lists to store vertices and edges in order
        List<V> vertexList = new ArrayList<>();
        List<E> edgeList = new ArrayList<>();
        
        // Get first edge and its vertices
        E firstEdge = tour.iterator().next();
        V start = graph.getEdgeSource(firstEdge);
        V current = graph.getEdgeTarget(firstEdge);
        
        vertexList.add(start);
        vertexList.add(current);
        edgeList.add(firstEdge);
        
        // Remove first edge from set
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
                    vertexList.add(current);
                    edgeList.add(edge);
                    remaining.remove(edge);
                    break;
                }
            }
            
            if (!found) {
                throw new IllegalArgumentException("Invalid tour: edges do not form connected path");
            }
        }
        
        // Verify tour is complete (ends at start)
        if (!current.equals(start)) {
            throw new IllegalArgumentException("Invalid tour: path does not end at starting vertex");
        }
        
        // Calculate total weight
        double weight = 0.0;
        for (E edge : edgeList) {
            weight += graph.getEdgeWeight(edge);
        }
        
        return new GraphWalk<>(graph, vertexList, weight);
    }
}