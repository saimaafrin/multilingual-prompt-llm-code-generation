import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.Path;

import java.util.HashSet;
import java.util.Set;

public class GraphTour<V, E> {

    /** 
     * Trasforma una rappresentazione di un insieme in un percorso di grafo.
     * @param tour un insieme contenente i bordi del tour
     * @param graph il grafo
     * @return un percorso di grafo
     */
    protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
        if (tour == null || tour.isEmpty() || graph == null) {
            return null;
        }

        Set<V> vertices = new HashSet<>();
        for (E edge : tour) {
            vertices.add(graph.getEdgeSource(edge));
            vertices.add(graph.getEdgeTarget(edge));
        }

        Path<V, E> path = new Path<>();
        for (E edge : tour) {
            path.add(edge);
        }

        return path;
    }
}