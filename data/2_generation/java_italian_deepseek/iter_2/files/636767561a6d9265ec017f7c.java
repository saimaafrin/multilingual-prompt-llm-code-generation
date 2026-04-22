import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;

import java.util.*;

/**
 * Trasforma una rappresentazione di un insieme in un percorso di grafo.
 * @param <V> il tipo di vertice del grafo
 * @param <E> il tipo di bordo del grafo
 * @param tour un insieme contenente i bordi del tour
 * @param graph il grafo
 * @return un percorso di grafo
 */
protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("Il tour non può essere vuoto.");
    }

    // Trova il vertice iniziale
    V startVertex = null;
    for (E edge : tour) {
        startVertex = graph.getEdgeSource(edge);
        break;
    }

    // Costruisci il percorso
    List<E> edgeList = new ArrayList<>();
    V currentVertex = startVertex;
    Set<E> remainingEdges = new HashSet<>(tour);

    while (!remainingEdges.isEmpty()) {
        boolean edgeFound = false;
        for (E edge : remainingEdges) {
            if (graph.getEdgeSource(edge).equals(currentVertex)) {
                edgeList.add(edge);
                currentVertex = graph.getEdgeTarget(edge);
                remainingEdges.remove(edge);
                edgeFound = true;
                break;
            } else if (graph.getEdgeTarget(edge).equals(currentVertex)) {
                edgeList.add(edge);
                currentVertex = graph.getEdgeSource(edge);
                remainingEdges.remove(edge);
                edgeFound = true;
                break;
            }
        }
        if (!edgeFound) {
            throw new IllegalArgumentException("Il tour non è valido o il grafo non è connesso.");
        }
    }

    // Costruisci il GraphPath
    return new DefaultGraphPath<>(graph, startVertex, currentVertex, edgeList, 0.0);
}