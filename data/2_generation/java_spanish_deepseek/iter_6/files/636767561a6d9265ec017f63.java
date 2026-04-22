import java.util.*;

public class Graph {
    private Set<Integer> visitedVertices;
    private Set<Integer> allVertices;

    public Graph(Set<Integer> allVertices) {
        this.allVertices = allVertices;
        this.visitedVertices = new HashSet<>();
    }

    @Override
    public boolean hasNext() {
        return !visitedVertices.containsAll(allVertices);
    }
}