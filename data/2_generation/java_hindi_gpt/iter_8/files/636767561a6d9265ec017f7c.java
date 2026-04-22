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
     * एक सेट प्रतिनिधित्व से एक ग्राफ पथ में परिवर्तन करें।
     * @param tour एक सेट जो यात्रा के किनारों को शामिल करता है
     * @param graph ग्राफ
     * @return एक ग्राफ पथ
     */
    protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
        List<V> vertexList = new ArrayList<>();
        V previousVertex = null;

        for (E edge : tour) {
            V sourceVertex = graph.getEdgeSource(edge);
            V targetVertex = graph.getEdgeTarget(edge);

            if (previousVertex == null) {
                vertexList.add(sourceVertex);
                previousVertex = targetVertex;
            } else {
                if (!previousVertex.equals(sourceVertex)) {
                    vertexList.add(previousVertex);
                }
                vertexList.add(targetVertex);
                previousVertex = targetVertex;
            }
        }

        return new GraphPath<V, E>() {
            @Override
            public Graph<V, E> getGraph() {
                return graph;
            }

            @Override
            public List<V> getVertexList() {
                return vertexList;
            }

            @Override
            public List<E> getEdgeList() {
                return new ArrayList<>(tour);
            }

            @Override
            public V getStartVertex() {
                return vertexList.isEmpty() ? null : vertexList.get(0);
            }

            @Override
            public V getEndVertex() {
                return vertexList.isEmpty() ? null : vertexList.get(vertexList.size() - 1);
            }

            @Override
            public double getWeight() {
                return 0; // Weight calculation can be implemented if needed
            }
        };
    }
}