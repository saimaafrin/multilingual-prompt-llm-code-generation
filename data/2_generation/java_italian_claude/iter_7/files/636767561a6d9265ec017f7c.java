import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.GraphWalk;
import java.util.*;

public class TourConverter {

    protected <V,E> GraphPath<V,E> edgeSetToTour(Set<E> tour, Graph<V,E> graph) {
        if (tour == null || tour.isEmpty() || graph == null) {
            return null;
        }

        // Create lists to store vertices and edges of the path
        List<V> vertexList = new ArrayList<>();
        List<E> edgeList = new ArrayList<>();
        
        // Get first edge and its vertices
        E firstEdge = tour.iterator().next();
        V startVertex = graph.getEdgeSource(firstEdge);
        V currentVertex = graph.getEdgeTarget(firstEdge);
        
        // Add first vertex and edge
        vertexList.add(startVertex);
        edgeList.add(firstEdge);
        
        // Remove first edge from set
        Set<E> remainingEdges = new HashSet<>(tour);
        remainingEdges.remove(firstEdge);
        
        // Build path by connecting edges
        while (!remainingEdges.isEmpty()) {
            vertexList.add(currentVertex);
            
            // Find next edge that connects to current vertex
            E nextEdge = null;
            for (E edge : remainingEdges) {
                if (graph.getEdgeSource(edge).equals(currentVertex)) {
                    nextEdge = edge;
                    currentVertex = graph.getEdgeTarget(edge);
                    break;
                } else if (graph.getEdgeTarget(edge).equals(currentVertex)) {
                    nextEdge = edge;
                    currentVertex = graph.getEdgeSource(edge);
                    break;
                }
            }
            
            if (nextEdge == null) {
                throw new IllegalArgumentException("Invalid tour: edges do not form a continuous path");
            }
            
            edgeList.add(nextEdge);
            remainingEdges.remove(nextEdge);
        }
        
        // Add final vertex to complete the path
        vertexList.add(currentVertex);
        
        // Calculate total weight of path
        double weight = 0.0;
        for (E edge : edgeList) {
            weight += graph.getEdgeWeight(edge);
        }
        
        return new GraphWalk<>(graph, vertexList, weight);
    }
}