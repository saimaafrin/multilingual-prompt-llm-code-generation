import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultGraphPath;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 将集合表示转换为图路径。
 * @param tour 包含可巡回边的集合
 * @param graph 图
 * @return 图路径
 */
protected <V, E> GraphPath<V, E> edgeSetToTour(Set<E> tour, Graph<V, E> graph) {
    if (tour.isEmpty()) {
        return new DefaultGraphPath<>(graph, new ArrayList<>(), 0);
    }

    // 将边集合转换为顶点列表
    List<V> vertexList = new ArrayList<>();
    E firstEdge = tour.iterator().next();
    V startVertex = graph.getEdgeSource(firstEdge);
    V currentVertex = startVertex;

    vertexList.add(currentVertex);

    for (E edge : tour) {
        V source = graph.getEdgeSource(edge);
        V target = graph.getEdgeTarget(edge);

        if (source.equals(currentVertex)) {
            vertexList.add(target);
            currentVertex = target;
        } else if (target.equals(currentVertex)) {
            vertexList.add(source);
            currentVertex = source;
        } else {
            throw new IllegalArgumentException("The tour is not a valid path in the graph.");
        }
    }

    // 计算路径权重
    double weight = 0;
    for (E edge : tour) {
        weight += graph.getEdgeWeight(edge);
    }

    return new DefaultGraphPath<>(graph, vertexList, weight);
}