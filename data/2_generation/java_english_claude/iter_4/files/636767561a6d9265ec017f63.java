import java.util.*;

public class GraphTraversal implements Iterator<Vertex> {
    private Set<Vertex> visited;
    private Queue<Vertex> queue;
    
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}