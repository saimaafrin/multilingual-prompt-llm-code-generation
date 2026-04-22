import java.util.HashSet;
import java.util.Set;

private Set<V> initVisibleVertices() {
    Set<V> visibleVertices = new HashSet<>();
    
    // 假设 edges 是图中所有边的集合
    for (Edge<V> edge : edges) {
        visibleVertices.add(edge.getSource());
        visibleVertices.add(edge.getTarget());
    }
    
    return visibleVertices;
}

// 假设 Edge 类的定义如下：
class Edge<V> {
    private V source;
    private V target;

    public Edge(V source, V target) {
        this.source = source;
        this.target = target;
    }

    public V getSource() {
        return source;
    }

    public V getTarget() {
        return target;
    }
}