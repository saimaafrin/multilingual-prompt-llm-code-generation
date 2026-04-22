import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.GraphWalk;
import java.util.*;

public class TourConverter {

    /**
     * Trasforma una rappresentazione di un insieme in un percorso di grafo.
     * @param tour un insieme contenente i bordi del tour
     * @param graph il grafo
     * @return un percorso di grafo
     */
    protected <V,E> GraphPath<V,E> edgeSetToTour(Set<E> tour, Graph<V,E> graph) {
        if (tour == null || tour.isEmpty()) {
            return null;
        }

        List<V> vertexList = new ArrayList<>();
        List<E> edgeList = new ArrayList<>();
        
        // Get first edge and its vertices
        E firstEdge = tour.iterator().next();
        V startVertex = graph.getEdgeSource(firstEdge);
        V currentVertex = graph.getEdgeTarget(firstEdge);
        
        vertexList.add(startVertex);
        vertexList.add(currentVertex);
        edgeList.add(firstEdge);
        tour.remove(firstEdge);

        // Build path by connecting edges
        while (!tour.isEmpty()) {
            boolean found = false;
            for (E edge : tour) {
                V source = graph.getEdgeSource(edge);
                V target = graph.getEdgeTarget(edge);
                
                if (source.equals(currentVertex)) {
                    currentVertex = target;
                    vertexList.add(currentVertex);
                    edgeList.add(edge);
                    tour.remove(edge);
                    found = true;
                    break;
                } else if (target.equals(currentVertex)) {
                    currentVertex = source;
                    vertexList.add(currentVertex);
                    edgeList.add(edge);
                    tour.remove(edge);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                throw new IllegalArgumentException("The edge set does not form a valid tour");
            }
        }

        // Verify tour is complete (ends at start vertex)
        if (!currentVertex.equals(startVertex)) {
            throw new IllegalArgumentException("The edge set does not form a complete tour");
        }

        double weight = edgeList.stream()
            .mapToDouble(graph::getEdgeWeight)
            .sum();

        return new GraphWalk<>(graph, startVertex, startVertex, vertexList, edgeList, weight);
    }
}