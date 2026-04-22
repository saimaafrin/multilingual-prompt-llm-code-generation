import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Trasforma una rappresentazione di un insieme in un percorso di grafo.
 * @param tour un insieme contenente i bordi del tour
 * @param graph il grafo
 * @return un percorso di grafo
 */
protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("Il tour non può essere vuoto.");
    }

    List<V> vertexList = new ArrayList<>();
    List<E> edgeList = new ArrayList<>(tour);

    // Trova il primo vertice del percorso
    E firstEdge = edgeList.get(0);
    V startVertex = graph.getEdgeSource(firstEdge);
    vertexList.add(startVertex);

    // Costruisci il percorso
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

    return new DefaultGraphPath<>(graph, vertexList, edgeList, 0);
}