import java.util.*;

public class GraphTraversal implements Iterator<Vertex> {
    private Set<Vertex> visited;
    private Queue<Vertex> queue;
    
    @Override
    public boolean hasNext() {
        // Return true if queue is not empty (there are still unvisited vertices)
        return !queue.isEmpty();
    }
}