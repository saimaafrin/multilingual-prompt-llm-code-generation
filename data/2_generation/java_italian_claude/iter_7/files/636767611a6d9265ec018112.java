import java.util.NoSuchElementException;

public class VertexProvider<V> implements Iterator<V> {
    
    private Queue<V> vertexQueue;
    
    public VertexProvider() {
        this.vertexQueue = new LinkedList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected V provideNextVertex() {
        if (vertexQueue.isEmpty()) {
            throw new NoSuchElementException("No more vertices available");
        }
        return vertexQueue.poll();
    }
}