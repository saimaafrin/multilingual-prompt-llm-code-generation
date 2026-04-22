import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.path.GraphPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GraphTour<V, E extends DefaultEdge> {

    /**
     * Trasforma una rappresentazione di un insieme in un percorso di grafo.
     * @param tour un insieme contenente i bordi del tour
     * @param graph il grafo
     * @return un percorso di grafo
     */
    protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
        List<V> vertexList = new ArrayList<>();
        for (E edge : tour) {
            vertexList.add(graph.getEdgeSource(edge));
            vertexList.add(graph.getEdgeTarget(edge));
        }
        
        // Remove duplicates while maintaining order
        List<V> uniqueVertices = new ArrayList<>();
        for (V vertex : vertexList) {
            if (!uniqueVertices.contains(vertex)) {
                uniqueVertices.add(vertex);
            }
        }

        // Create a path from the unique vertices
        return new GraphPath<V, E>() {
            @Override
            public List<E> getEdgeList() {
                List<E> edges = new ArrayList<>();
                for (int i = 0; i < uniqueVertices.size() - 1; i++) {
                    edges.add(graph.getEdge(uniqueVertices.get(i), uniqueVertices.get(i + 1)));
                }
                return edges;
            }

            @Override
            public V getStartVertex() {
                return uniqueVertices.get(0);
            }

            @Override
            public V getEndVertex() {
                return uniqueVertices.get(uniqueVertices.size() - 1);
            }

            @Override
            public double getWeight() {
                return 0; // Weight calculation can be added if needed
            }

            @Override
            public Graph<V, E> getGraph() {
                return graph;
            }
        };
    }
}