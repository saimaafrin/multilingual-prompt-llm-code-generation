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
protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        return new GraphWalk<>(graph, new ArrayList<>(), 0.0);
    }

    List<V> vertexList = new ArrayList<>();
    List<E> edgeList = new ArrayList<>(tour);

    // Start with the source vertex of the first edge
    E firstEdge = edgeList.get(0);
    V startVertex = graph.getEdgeSource(firstEdge);
    vertexList.add(startVertex);

    // Traverse the edges to build the vertex list
    V currentVertex = startVertex;
    for (E edge : edgeList) {
        V targetVertex = graph.getEdgeTarget(edge);
        if (targetVertex.equals(currentVertex)) {
            targetVertex = graph.getEdgeSource(edge);
        }
        vertexList.add(targetVertex);
        currentVertex = targetVertex;
    }

    // Calculate the total weight of the path
    double totalWeight = 0.0;
    for (E edge : edgeList) {
        totalWeight += graph.getEdgeWeight(edge);
    }

    return new GraphWalk<>(graph, vertexList, edgeList, totalWeight);
}