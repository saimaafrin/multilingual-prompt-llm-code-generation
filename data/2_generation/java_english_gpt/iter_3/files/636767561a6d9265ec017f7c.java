import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Triple;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class GraphUtils<V, E> {

    /** 
     * Transform from a Set representation to a graph path.
     * @param tour a set containing the edges of the tour
     * @param graph the graph
     * @return a graph path
     */
    protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
        if (tour == null || graph == null || tour.isEmpty()) {
            return null;
        }

        // Create a list to hold the vertices in the path
        List<V> vertexList = new ArrayList<>();
        E previousEdge = null;

        for (E edge : tour) {
            // Get the source and target vertices of the edge
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);

            // Add the source vertex if it's not already in the list
            if (!vertexList.contains(source)) {
                vertexList.add(source);
            }

            // Add the target vertex
            if (!vertexList.contains(target)) {
                vertexList.add(target);
            }

            previousEdge = edge;
        }

        // Create a GraphPath object
        return new GraphPath<V, E>() {
            @Override
            public Graph<V, E> getGraph() {
                return graph;
            }

            @Override
            public List<E> getEdgeList() {
                return new ArrayList<>(tour);
            }

            @Override
            public V getStartVertex() {
                return vertexList.get(0);
            }

            @Override
            public V getEndVertex() {
                return vertexList.get(vertexList.size() - 1);
            }

            @Override
            public double getWeight() {
                return 0; // Weight calculation can be added if needed
            }

            @Override
            public int getLength() {
                return tour.size();
            }
        };
    }
}