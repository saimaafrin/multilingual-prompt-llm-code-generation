import java.util.Iterator;

public class GraphIterator implements Iterator<Integer> {
    private boolean[] visited;
    private int currentIndex;

    public GraphIterator(boolean[] visited) {
        this.visited = visited;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        for (int i = currentIndex; i < visited.length; i++) {
            if (!visited[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more unvisited vertices.");
        }
        while (currentIndex < visited.length && visited[currentIndex]) {
            currentIndex++;
        }
        return currentIndex++;
    }
}