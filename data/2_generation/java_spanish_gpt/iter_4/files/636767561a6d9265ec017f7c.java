import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Triple;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GraphUtils<V, E> {

    /** 
     * Transforma una representación de conjunto en un camino de grafo.
     * @param tour un conjunto que contiene los bordes del recorrido
     * @param graph el grafo
     * @return un camino de grafo
     */
    protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
        List<V> vertexList = new ArrayList<>();
        for (E edge : tour) {
            if (graph.containsEdge(edge)) {
                vertexList.add(graph.getEdgeSource(edge));
                vertexList.add(graph.getEdgeTarget(edge));
            }
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
            public E getStartVertex() {
                return uniqueVertices.isEmpty() ? null : uniqueVertices.get(0);
            }

            @Override
            public E getEndVertex() {
                return uniqueVertices.isEmpty() ? null : uniqueVertices.get(uniqueVertices.size() - 1);
            }

            @Override
            public double getWeight() {
                return 0; // Weight calculation can be implemented if needed
            }

            @Override
            public List<E> getEdgeList() {
                return new ArrayList<>(tour);
            }
        };
    }
}