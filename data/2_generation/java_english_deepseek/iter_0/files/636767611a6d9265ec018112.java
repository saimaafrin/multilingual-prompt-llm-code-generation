import java.util.NoSuchElementException;

/**
 * {@inheritDoc}
 */
@Override
protected V provideNextVertex() {
    if (vertices.isEmpty()) {
        throw new NoSuchElementException("No more vertices available.");
    }
    return vertices.remove(0); // Assuming vertices is a List<V> containing the vertices
}