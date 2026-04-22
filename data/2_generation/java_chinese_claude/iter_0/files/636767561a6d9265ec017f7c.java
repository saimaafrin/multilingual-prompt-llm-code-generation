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
        V startVertex = graph.getEdgeSource(firstEdge);
        V currentVertex = graph.getEdgeTarget(firstEdge);
        
        vertexList.add(startVertex);
        vertexList.add(currentVertex);
        edgeList.add(firstEdge);
        
        // Remove first edge from set
        Set<E> remainingEdges = new HashSet<>(tour);
        remainingEdges.remove(firstEdge);
        
        // Build path by connecting edges
        while (!remainingEdges.isEmpty()) {
            boolean found = false;
            for (E edge : remainingEdges) {
                V source = graph.getEdgeSource(edge);
                V target = graph.getEdgeTarget(edge);
                
                if (source.equals(currentVertex)) {
                    currentVertex = target;
                    found = true;
                } else if (target.equals(currentVertex)) {
                    currentVertex = source;
                    found = true;
                }
                
                if (found) {
                    vertexList.add(currentVertex);
                    edgeList.add(edge);
                    remainingEdges.remove(edge);
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
        
        // Create and return graph path
        double weight = edgeList.stream()
            .mapToDouble(graph::getEdgeWeight)
            .sum();
            
        return new GraphWalk<>(graph, vertexList, weight);
    }
}