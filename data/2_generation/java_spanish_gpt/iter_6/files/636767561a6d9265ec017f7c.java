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
            public V getStartVertex() {
                return vertexList.get(0);
            }

            @Override
            public V getEndVertex() {
                return vertexList.get(vertexList.size() - 1);
            }

            @Override
            public List<E> getEdgeList() {
                return new ArrayList<>(tour);
            }

            @Override
            public double getWeight() {
                return 0; // Weight calculation can be implemented if needed
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