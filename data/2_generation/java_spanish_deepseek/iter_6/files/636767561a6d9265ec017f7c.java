import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("The tour set cannot be empty.");
    }

    // Convert the set of edges to a list of edges
    List<E> edgeList = new ArrayList<>(tour);

    // Extract the vertices from the edges to form the path
    List<V> vertexList = new ArrayList<>();
    V startVertex = graph.getEdgeSource(edgeList.get(0));
    vertexList.add(startVertex);

    for (E edge : edgeList) {
        V targetVertex = graph.getEdgeTarget(edge);
        vertexList.add(targetVertex);
    }

    // Create and return the GraphPath
    return new DefaultGraphPath<>(graph, vertexList, edgeList);
}