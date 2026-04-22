import java.util.NoSuchElementException;

/**
 * {@inheritDoc}
 */
@Override
protected V provideNextVertex() {
    if (hasNext()) {
        return vertices.get(currentIndex++);
    } else {
        throw new NoSuchElementException("No more vertices available.");
    }
}