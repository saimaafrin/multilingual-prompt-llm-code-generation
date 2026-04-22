import java.util.Iterator;
import java.util.NoSuchElementException;

public class NextVertexProvider<V> {
    /**
     * Provides the next vertex in a sequence or iteration.
     * 
     * @return the next vertex in the sequence
     * @throws NoSuchElementException if no more vertices are available
     */
    @Override
    protected V provideNextVertex() {
        // If no iterator is available or no more elements exist
        if (this.vertexIterator == null || !this.vertexIterator.hasNext()) {
            throw new NoSuchElementException("No more vertices available");
        }
        
        // Return the next vertex from the iterator
        return this.vertexIterator.next();
    }
    
    // Supporting instance variables (these would typically be set up in the constructor)
    private Iterator<V> vertexIterator;
}