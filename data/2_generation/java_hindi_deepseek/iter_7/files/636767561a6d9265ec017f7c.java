import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;

import java.util.*;

public class GraphUtils<V, E> {

    /**
     * एक सेट प्रतिनिधित्व से एक ग्राफ पथ में परिवर्तन करें।
     * @param tour एक सेट जो यात्रा के किनारों को शामिल करता है
     * @param graph ग्राफ
     * @return एक ग्राफ पथ
     */
    protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
        if (tour.isEmpty()) {
            throw new IllegalArgumentException("Tour set cannot be empty.");
        }

        // Create a map to store the adjacency list
        Map<V, List<E>> adjacencyMap = new HashMap<>();
        for (E edge : tour) {
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            adjacencyMap.computeIfAbsent(source, k -> new ArrayList<>()).add(edge);
            adjacencyMap.computeIfAbsent(target, k -> new ArrayList<>()).add(edge);
        }

        // Find the starting vertex (a vertex with only one edge)
        V startVertex = null;
        for (Map.Entry<V, List<E>> entry : adjacencyMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                startVertex = entry.getKey();
                break;
            }
        }

        if (startVertex == null) {
            throw new IllegalArgumentException("The tour does not form a valid path.");
        }

        // Build the path
        List<E> edgeList = new ArrayList<>();
        V currentVertex = startVertex;
        V previousVertex = null;

        while (true) {
            List<E> edges = adjacencyMap.get(currentVertex);
            if (edges == null || edges.isEmpty()) {
                break;
            }

            E nextEdge = edges.get(0);
            if (edges.size() > 1) {
                // Choose the edge that is not the previous edge
                nextEdge = edges.get(0).equals(previousVertex) ? edges.get(1) : edges.get(0);
            }

            edgeList.add(nextEdge);
            V nextVertex = graph.getEdgeSource(nextEdge).equals(currentVertex) ? graph.getEdgeTarget(nextEdge) : graph.getEdgeSource(nextEdge);
            previousVertex = currentVertex;
            currentVertex = nextVertex;

            // Remove the used edge from the adjacency map
            adjacencyMap.get(previousVertex).remove(nextEdge);
            adjacencyMap.get(currentVertex).remove(nextEdge);
        }

        // Create the GraphPath
        return new DefaultGraphPath<>(graph, edgeList, 0.0);
    }
}