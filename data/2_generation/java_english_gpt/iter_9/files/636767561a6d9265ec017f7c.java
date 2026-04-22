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
        if (tour == null || graph == null) {
            throw new IllegalArgumentException("Tour and graph cannot be null");
        }

        // Create a list to hold the vertices of the path
        List<V> vertices = new ArrayList<>();
        for (E edge : tour) {
            // Get the source and target vertices of the edge
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            if (!vertices.contains(source)) {
                vertices.add(source);
            }
            if (!vertices.contains(target)) {
                vertices.add(target);
            }
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
                return vertices.get(0);
            }

            @Override
            public V getEndVertex() {
                return vertices.get(vertices.size() - 1);
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
            public int getLength() {
                return tour.size();
            }
        };
    }
}