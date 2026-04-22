import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.GraphWalk;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);

        if (source.equals(currentVertex)) {
            vertexList.add(target);
            currentVertex = target;
        } else if (target.equals(currentVertex)) {
            vertexList.add(source);
            currentVertex = source;
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