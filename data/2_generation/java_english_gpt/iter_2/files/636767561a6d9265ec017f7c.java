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
        List<V> vertexList = new ArrayList<>();
        vertexList.add(startVertex);

        for (E edge : tour) {
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            if (!vertexList.contains(source)) {
                vertexList.add(source);
            }
            if (!vertexList.contains(target)) {
                vertexList.add(target);
            }
        }

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
                return startVertex;
            }

            @Override
            public V getEndVertex() {
                return endVertex;
            }

            @Override
            public double getWeight() {
                double weight = 0.0;
                for (E edge : tour) {
                    weight += graph.getEdgeWeight(edge);
                }
                return weight;
            }

            @Override
            public String toString() {
                return "GraphPath{" +
                        "vertices=" + vertexList +
                        ", edges=" + tour +
                        '}';
            }
        };
    }
}