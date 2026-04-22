import java.util.NoSuchElementException;

public class VertexIterator<V> implements Iterator<V> {
    private Queue<V> vertexQueue;
    
    /**
     * Returns the next vertex in the iteration.
     * @return the next vertex
     * @throws NoSuchElementException if there are no more vertices
     */
    @Override
    protected V provideNextVertex() {
        if (vertexQueue.isEmpty()) {
            throw new NoSuchElementException("No more vertices in the graph");
        }
        return vertexQueue.remove();
    }
}