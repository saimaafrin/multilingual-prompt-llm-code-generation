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
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);

            if (previousVertex == null) {
                vertexList.add(source);
            } else if (!previousVertex.equals(source)) {
                vertexList.add(source);
            }
            vertexList.add(target);
            previousVertex = target;
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
            public E getStartEdge() {
                return graph.getEdge(vertexList.get(0), vertexList.get(1));
            }

            @Override
            public E getEndEdge() {
                return graph.getEdge(vertexList.get(vertexList.size() - 2), vertexList.get(vertexList.size() - 1));
            }

            @Override
            public double getWeight() {
                return 0; // Weight calculation can be implemented if needed
            }

            @Override
            public int getLength() {
                return vertexList.size() - 1;
            }
        };
    }
}