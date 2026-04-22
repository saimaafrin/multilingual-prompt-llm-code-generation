import java.util.NoSuchElementException;

public class VertexIterator<V> implements Iterator<V> {
    private Queue<V> vertexQueue;
    
    /**
     * Provides the next vertex in the iteration sequence.
     * @return The next vertex in the iteration.
     * @throws NoSuchElementException if there are no more vertices.
     */
    @Override
    protected V provideNextVertex() {
        if (vertexQueue.isEmpty()) {
            throw new NoSuchElementException("No more vertices to iterate");
        }
        return vertexQueue.remove();
    }
}