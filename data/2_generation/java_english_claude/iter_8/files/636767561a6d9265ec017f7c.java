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

        // Get first edge and vertex
        E firstEdge = tour.iterator().next();
        V startVertex = graph.getEdgeSource(firstEdge);
        
        List<E> orderedEdges = new ArrayList<>();
        List<V> orderedVertices = new ArrayList<>();
        orderedVertices.add(startVertex);
        
        V currentVertex = startVertex;
        Set<E> remainingEdges = new HashSet<>(tour);
        
        // Build ordered path
        while (!remainingEdges.isEmpty()) {
            E nextEdge = null;
            
            // Find edge connected to current vertex
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
                throw new IllegalArgumentException("Invalid tour: edges do not form connected path");
            }
            
            orderedEdges.add(nextEdge);
            orderedVertices.add(currentVertex);
            remainingEdges.remove(nextEdge);
        }
        
        // Verify tour ends at start vertex
        if (!currentVertex.equals(startVertex)) {
            throw new IllegalArgumentException("Invalid tour: does not end at starting vertex");
        }
        
        double weight = 0.0;
        for (E edge : orderedEdges) {
            weight += graph.getEdgeWeight(edge);
        }
        
        return new GraphWalk<>(graph, startVertex, startVertex, orderedVertices, orderedEdges, weight);
    }
}