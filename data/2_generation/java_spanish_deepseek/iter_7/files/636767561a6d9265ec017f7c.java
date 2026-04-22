import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;

import java.util.*;

/**
 * Transforma una representación de conjunto en un camino de grafo.
 * @param tour un conjunto que contiene los bordes del recorrido
 * @param graph el grafo
 * @return un camino de grafo
 */
protected GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        throw new IllegalArgumentException("El conjunto de bordes no puede estar vacío.");
    }

    // Crear una lista de vértices basada en los bordes del tour
    List<V> vertexList = new ArrayList<>();
    Iterator<E> edgeIterator = tour.iterator();
    E firstEdge = edgeIterator.next();
    V startVertex = graph.getEdgeSource(firstEdge);
    V endVertex = graph.getEdgeTarget(firstEdge);

    vertexList.add(startVertex);
    vertexList.add(endVertex);

    while (edgeIterator.hasNext()) {
        E edge = edgeIterator.next();
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);

        if (source.equals(vertexList.get(vertexList.size() - 1))) {
            vertexList.add(target);
        } else if (target.equals(vertexList.get(vertexList.size() - 1))) {
            vertexList.add(source);
        } else {
            throw new IllegalArgumentException("El conjunto de bordes no forma un camino válido.");
        }
    }

    // Verificar si el camino es cerrado (ciclo)
    if (!vertexList.get(0).equals(vertexList.get(vertexList.size() - 1))) {
        throw new IllegalArgumentException("El conjunto de bordes no forma un ciclo válido.");
    }

    // Crear el GraphPath
    return new DefaultGraphPath<>(graph, vertexList, tour);
}