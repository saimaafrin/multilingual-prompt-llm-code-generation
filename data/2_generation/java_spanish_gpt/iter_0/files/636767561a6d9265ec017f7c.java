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
        V startVertex = null;

        for (E edge : tour) {
            if (startVertex == null) {
                startVertex = graph.getEdgeSource(edge);
            }
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
                double weight = 0.0;
                for (E edge : getEdgeList()) {
                    weight += graph.getEdgeWeight(edge);
                }
                return weight;
            }

            @Override
            public String toString() {
                return "GraphPath{" +
                        "vertices=" + uniqueVertices +
                        ", edges=" + getEdgeList() +
                        '}';
            }
        };
    }
}