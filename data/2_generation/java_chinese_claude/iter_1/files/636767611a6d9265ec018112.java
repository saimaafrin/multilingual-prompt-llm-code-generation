import java.util.NoSuchElementException;

public class VertexIterator<V> implements Iterator<V> {
    private Queue<V> vertexQueue;
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected V provideNextVertex() {
        if (vertexQueue.isEmpty()) {
            throw new NoSuchElementException("No more vertices to iterate");
        }
        return vertexQueue.poll();
    }
}