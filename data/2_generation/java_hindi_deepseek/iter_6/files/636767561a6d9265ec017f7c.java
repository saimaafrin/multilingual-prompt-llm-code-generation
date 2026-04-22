import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * एक सेट प्रतिनिधित्व से एक ग्राफ पथ में परिवर्तन करें।
 * @param tour एक सेट जो यात्रा के किनारों को शामिल करता है
 * @param graph ग्राफ
 * @return एक ग्राफ पथ
 */
protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("Tour set cannot be empty.");
    }

    List<E> edgeList = new ArrayList<>(tour);
    List<V> vertexList = new ArrayList<>();

    // Start with the source vertex of the first edge
    E firstEdge = edgeList.get(0);
    V startVertex = graph.getEdgeSource(firstEdge);
    vertexList.add(startVertex);

    // Traverse the edges to build the vertex list
    V currentVertex = startVertex;
    for (E edge : edgeList) {
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);

        if (source.equals(currentVertex)) {
            vertexList.add(target);
            currentVertex = target;
        } else if (target.equals(currentVertex)) {
            vertexList.add(source);
            currentVertex = source;
        } else {
            throw new IllegalArgumentException("Edges in the tour set do not form a continuous path.");
        }
    }

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, vertexList, edgeList, 0.0);
}