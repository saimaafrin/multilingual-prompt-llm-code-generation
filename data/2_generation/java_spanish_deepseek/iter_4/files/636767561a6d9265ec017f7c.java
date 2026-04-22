import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("The tour set cannot be empty.");
    }

    // Convert the set of edges to a list to represent the path
    List<E> edgeList = new ArrayList<>(tour);

    // Determine the start and end vertices of the path
    V startVertex = graph.getEdgeSource(edgeList.get(0));
    V endVertex = graph.getEdgeTarget(edgeList.get(edgeList.size() - 1));

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, startVertex, endVertex, edgeList);
}