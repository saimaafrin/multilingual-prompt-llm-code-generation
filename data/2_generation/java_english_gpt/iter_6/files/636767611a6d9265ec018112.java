import java.util.Iterator;

public class VertexProvider<V> {
    private Iterator<V> vertexIterator;

    public VertexProvider(Iterator<V> vertexIterator) {
        this.vertexIterator = vertexIterator;
    }

    /** 
     * {@inheritDoc}
     */
    @Override 
    protected V provideNextVertex() {
        if (vertexIterator.hasNext()) {
            return vertexIterator.next();
        }
        return null; // or throw an exception based on your design choice
    }
}