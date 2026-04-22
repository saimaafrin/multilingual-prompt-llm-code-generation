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

    // Creiamo una lista per memorizzare i vertici del percorso
    List<V> vertexList = new ArrayList<>();

    // Prendiamo il primo bordo per iniziare
    E firstEdge = tour.iterator().next();
    V startVertex = graph.getEdgeSource(firstEdge);
    V endVertex = graph.getEdgeTarget(firstEdge);

    // Aggiungiamo i vertici del primo bordo alla lista
    vertexList.add(startVertex);
    vertexList.add(endVertex);

    // Rimuoviamo il primo bordo dal tour
    tour.remove(firstEdge);

    // Continuiamo a costruire il percorso finché ci sono bordi nel tour
    while (!tour.isEmpty()) {
        boolean foundNextEdge = false;
        for (E edge : tour) {
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);

            // Controlliamo se il bordo può essere aggiunto al percorso
            if (source.equals(vertexList.get(vertexList.size() - 1))) {
                vertexList.add(target);
                tour.remove(edge);
                foundNextEdge = true;
                break;
            } else if (target.equals(vertexList.get(vertexList.size() - 1))) {
                vertexList.add(source);
                tour.remove(edge);
                foundNextEdge = true;
                break;
            }
        }

        if (!foundNextEdge) {
            throw new IllegalArgumentException("Il tour non è valido o non è connesso.");
        }
    }

    // Creiamo il percorso di grafo
    return new DefaultGraphPath<>(graph, vertexList, vertexList.size() - 1);
}