import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.GraphWalk;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * एक सेट प्रतिनिधित्व से एक ग्राफ पथ में परिवर्तन करें।
 * @param tour एक सेट जो यात्रा के किनारों को शामिल करता है
 * @param graph ग्राफ
 * @return एक ग्राफ पथ
 */
protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        return new GraphWalk<>(graph, new ArrayList<>(), 0.0);
    }

    List<E> edgeList = new ArrayList<>(tour);
    List<V> vertexList = new ArrayList<>();

    // Start with the source vertex of the first edge
    V startVertex = graph.getEdgeSource(edgeList.get(0));
    vertexList.add(startVertex);

    // Traverse the edges to build the vertex list
    for (E edge : edgeList) {
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);

        if (vertexList.get(vertexList.size() - 1).equals(source)) {
            vertexList.add(target);
        } else if (vertexList.get(vertexList.size() - 1).equals(target)) {
            vertexList.add(source);
        } else {
            throw new IllegalArgumentException("The edge set does not form a valid tour.");
        }
    }

    // Calculate the total weight of the path
    double totalWeight = 0.0;
    for (E edge : edgeList) {
        totalWeight += graph.getEdgeWeight(edge);
    }

    return new GraphWalk<>(graph, vertexList, edgeList, totalWeight);
}