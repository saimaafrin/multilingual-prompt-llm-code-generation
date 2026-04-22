import java.util.Iterator;
import java.util.NoSuchElementException;

public class VertexIterator<V> implements Iterator<V> {
    
    private V[] vertices;
    private int currentIndex;
    
    public VertexIterator(V[] vertices) {
        this.vertices = vertices;
        this.currentIndex = 0;
    }

    @Override
    protected V proporcionarSiguienteVertice() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return vertices[currentIndex++];
    }

    @Override
    public boolean hasNext() {
        return currentIndex < vertices.length;
    }

    @Override
    public V next() {
        return proporcionarSiguienteVertice();
    }
}