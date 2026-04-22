import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.GraphWalk;
import java.util.*;

public class TourConverter {

    protected <V,E> GraphPath<V,E> edgeSetToTour(Set<E> tour, Graph<V,E> graph) {
        if (tour.isEmpty()) {
            return null;
        }

        // Create lists to store vertices and edges
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
                    vertexList.add(current);
                    edgeList.add(edge);
                    remaining.remove(edge);
                    found = true;
                    break;
                } else if (target.equals(current)) {
                    current = source;
                    vertexList.add(current);
                    edgeList.add(edge);
                    remaining.remove(edge);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                throw new IllegalArgumentException("Edge set does not form a valid tour");
            }
        }
        
        // Verify tour is closed
        if (!current.equals(start)) {
            throw new IllegalArgumentException("Edge set does not form a closed tour");
        }
        
        // Calculate total weight
        double weight = 0.0;
        for (E edge : edgeList) {
            weight += graph.getEdgeWeight(edge);
        }
        
        return new GraphWalk<>(graph, vertexList, weight);
    }
}