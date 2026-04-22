import java.util.NoSuchElementException;

public class IteradorVertices<V> implements Iterator<V> {
    
    private int posicionActual;
    private V[] vertices;
    
    @Override
    protected V proporcionarSiguienteVertice() {
        if (!hayMasVertices()) {
            throw new NoSuchElementException("No hay más vértices para iterar");
        }
        
        V vertice = vertices[posicionActual];
        posicionActual++;
        return vertice;
    }
    
    private boolean hayMasVertices() {
        return posicionActual < vertices.length && vertices[posicionActual] != null;
    }
}