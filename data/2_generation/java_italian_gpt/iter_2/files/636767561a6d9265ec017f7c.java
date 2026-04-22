import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Triple;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;

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
        
        return new GraphPath<V, E>() {
            @Override
            public Graph<V, E> getGraph() {
                return graph;
            }

            @Override
            public List<V> getVertexList() {
                return uniqueVertices;
            }

            @Override
            public E getStartEdge() {
                return graph.getEdge(uniqueVertices.get(0), uniqueVertices.get(1));
            }

            @Override
            public E getEndEdge() {
                return graph.getEdge(uniqueVertices.get(uniqueVertices.size() - 2), uniqueVertices.get(uniqueVertices.size() - 1));
            }

            @Override
            public double getWeight() {
                return 0; // Weight calculation can be implemented if needed
            }

            @Override
            public int getLength() {
                return uniqueVertices.size() - 1;
            }
        };
    }
}