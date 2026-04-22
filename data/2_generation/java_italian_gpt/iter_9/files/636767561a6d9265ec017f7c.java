import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphTour<V, E> {

    /**
     * Trasforma una rappresentazione di un insieme in un percorso di grafo.
     * @param tour un insieme contenente i bordi del tour
     * @param graph il grafo
     * @return un percorso di grafo
     */
    protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
        List<V> vertices = new ArrayList<>();
        for (E edge : tour) {
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            if (!vertices.contains(source)) {
                vertices.add(source);
            }
            if (!vertices.contains(target)) {
                vertices.add(target);
            }
        }
        return new GraphPathImpl<>(graph, vertices);
    }

    private class GraphPathImpl<V, E> implements GraphPath<V, E> {
        private final Graph<V, E> graph;
        private final List<V> vertices;

        public GraphPathImpl(Graph<V, E> graph, List<V> vertices) {
            this.graph = graph;
            this.vertices = vertices;
        }

        @Override
        public List<V> getVertexList() {
            return vertices;
        }

        @Override
        public List<E> getEdgeList() {
            List<E> edges = new ArrayList<>();
            for (int i = 0; i < vertices.size() - 1; i++) {
                edges.add(graph.getEdge(vertices.get(i), vertices.get(i + 1)));
            }
            return edges;
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
            for (E edge : getEdgeList()) {
                weight += graph.getEdgeWeight(edge);
            }
            return weight;
        }
    }
}