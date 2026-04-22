import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;

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

    List<E> edgeList = new ArrayList<>(tour);
    List<V> vertexList = new ArrayList<>();

    // Aggiungi il primo vertice del primo bordo
    E firstEdge = edgeList.get(0);
    V startVertex = graph.getEdgeSource(firstEdge);
    vertexList.add(startVertex);

    // Costruisci la lista dei vertici seguendo i bordi
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

    // Crea e restituisci il GraphPath
    return new DefaultGraphPath<>(graph, vertexList, edgeList, 0);
}