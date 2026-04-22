import java.util.*;

public class GraphIterator implements Iterator<Integer> {
    private Set<Integer> visited;
    private Set<Integer> vertices;

    public GraphIterator(Set<Integer> vertices) {
        this.vertices = vertices;
        this.visited = new HashSet<>();
    }

    @Override
    public boolean hasNext() {
        return !visited.containsAll(vertices);
    }

    @Override
    public Integer next() {
        for (Integer vertex : vertices) {
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                return vertex;
            }
        }
        throw new NoSuchElementException("No more vertices to visit");
    }
}