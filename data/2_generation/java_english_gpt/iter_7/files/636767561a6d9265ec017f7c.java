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

        V startVertex = null;
        V endVertex = null;
        for (E edge : tour) {
            if (startVertex == null) {
                startVertex = graph.getEdgeSource(edge);
            }
            endVertex = graph.getEdgeTarget(edge);
        }

        return new GraphPath<V, E>() {
            @Override
            public Graph<V, E> getGraph() {
                return graph;
            }

            @Override
            public V getStartVertex() {
                return startVertex;
            }

            @Override
            public V getEndVertex() {
                return endVertex;
            }

            @Override
            public List<E> getEdgeList() {
                return new ArrayList<>(tour);
            }

            @Override
            public double getWeight() {
                return 0; // Weight calculation can be implemented if needed
            }
        };
    }
}