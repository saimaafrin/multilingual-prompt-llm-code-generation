import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.GraphWalk;
import java.util.*;

public class GraphUtils {

    protected <V,E> GraphPath<V,E> edgeSetToTour(Set<E> tour, Graph<V,E> graph) {
        if (tour == null || tour.isEmpty() || graph == null) {
            return null;
        }

        // Create lists to store vertices and edges in order
        List<V> vertexList = new ArrayList<>();
        List<E> edgeList = new ArrayList<>();
        
        // Get first edge and its vertices
        E firstEdge = tour.iterator().next();
        V startVertex = graph.getEdgeSource(firstEdge);
        V currentVertex = graph.getEdgeTarget(firstEdge);
        
        vertexList.add(startVertex);
        vertexList.add(currentVertex);
        edgeList.add(firstEdge);
        
        Set<E> remainingEdges = new HashSet<>(tour);
        remainingEdges.remove(firstEdge);
        
        // Build the path by connecting edges
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
                throw new IllegalArgumentException("The edge set does not form a valid tour");
            }
        }
        
        // Verify if the tour is closed (ends at starting vertex)
        if (!currentVertex.equals(startVertex)) {
            throw new IllegalArgumentException("The edge set does not form a closed tour");
        }
        
        // Create and return the graph path
        return new GraphWalk<>(graph, vertexList, edgeList, 0.0);
    }
}