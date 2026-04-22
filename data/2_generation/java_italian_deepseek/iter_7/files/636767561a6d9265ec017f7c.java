import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.GraphWalk;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Trasforma una rappresentazione di un insieme in un percorso di grafo.
 * @param tour un insieme contenente i bordi del tour
 * @param graph il grafo
 * @return un percorso di grafo
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
            // If the edge doesn't connect to the last vertex, the tour is invalid
            throw new IllegalArgumentException("The provided edge set does not form a valid tour.");
        }
    }

    // Calculate the total weight of the path
    double totalWeight = 0.0;
    for (E edge : edgeList) {
        totalWeight += graph.getEdgeWeight(edge);
    }

    return new GraphWalk<>(graph, vertexList, edgeList, totalWeight);
}