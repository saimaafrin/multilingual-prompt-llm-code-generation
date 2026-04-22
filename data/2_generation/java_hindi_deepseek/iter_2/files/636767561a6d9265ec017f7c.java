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

    List<V> vertexList = new ArrayList<>();
    List<E> edgeList = new ArrayList<>(tour);

    // Start with the first edge
    E firstEdge = edgeList.get(0);
    V startVertex = graph.getEdgeSource(firstEdge);
    V endVertex = graph.getEdgeTarget(firstEdge);

    vertexList.add(startVertex);
    vertexList.add(endVertex);

    // Iterate through the remaining edges to build the path
    for (int i = 1; i < edgeList.size(); i++) {
        E currentEdge = edgeList.get(i);
        V source = graph.getEdgeSource(currentEdge);
        V target = graph.getEdgeTarget(currentEdge);

        if (source.equals(vertexList.get(vertexList.size() - 1))) {
            vertexList.add(target);
        } else if (target.equals(vertexList.get(vertexList.size() - 1))) {
            vertexList.add(source);
        } else {
            // If the edge doesn't connect to the last vertex, it's not a valid path
            throw new IllegalArgumentException("The edge set does not form a valid path in the graph.");
        }
    }

    // Calculate the total weight of the path
    double totalWeight = 0.0;
    for (E edge : edgeList) {
        totalWeight += graph.getEdgeWeight(edge);
    }

    return new GraphWalk<>(graph, vertexList, edgeList, totalWeight);
}