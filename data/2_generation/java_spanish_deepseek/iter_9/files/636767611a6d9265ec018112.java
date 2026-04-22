import java.util.NoSuchElementException;

/**
 * {@inheritDoc}
 */
@Override
protected V proporcionarSiguienteVertice() {
    if (!hasNext()) {
        throw new NoSuchElementException("No more vertices available.");
    }
    // Assuming 'vertices' is a collection of vertices and 'currentIndex' tracks the current position
    return vertices.get(currentIndex++);
}