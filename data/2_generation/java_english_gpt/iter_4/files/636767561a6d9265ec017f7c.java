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

        V startVertex = graph.getEdgeSource(tour.iterator().next());
        V endVertex = graph.getEdgeTarget(tour.iterator().next());
        for (E edge : tour) {
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
                double weight = 0.0;
                for (E edge : tour) {
                    weight += graph.getEdgeWeight(edge);
                }
                return weight;
            }
        };
    }
}