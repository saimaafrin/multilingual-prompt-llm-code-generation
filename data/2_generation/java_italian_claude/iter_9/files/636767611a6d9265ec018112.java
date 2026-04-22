import java.util.NoSuchElementException;

public class VertexIterator<V> implements Iterator<V> {
    private Queue<V> vertexQueue;
    
    /**
     * Returns the next vertex in the iteration.
     * Throws NoSuchElementException if no vertices remain.
     * @return the next vertex
     */
    @Override
    protected V provideNextVertex() {
        if (vertexQueue.isEmpty()) {
            throw new NoSuchElementException("No more vertices");
        }
        return vertexQueue.remove();
    }
    
    // Other required methods omitted for brevity
}