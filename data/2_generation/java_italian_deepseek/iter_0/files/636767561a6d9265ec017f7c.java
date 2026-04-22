import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;

import java.util.*;

/**
 * Trasforma una rappresentazione di un insieme in un percorso di grafo.
 * @param tour un insieme contenente i bordi del tour
 * @param graph il grafo
 * @return un percorso di grafo
 */
protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
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
    List<E> edgeList = new ArrayList<>(tour);
    List<V> vertexList = new ArrayList<>();
    vertexList.add(startVertex);

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
            throw new IllegalArgumentException("Il tour non è un percorso valido nel grafo.");
        }
    }

    // Crea e restituisce il GraphPath
    return new DefaultGraphPath<>(graph, startVertex, currentVertex, edgeList, vertexList);
}