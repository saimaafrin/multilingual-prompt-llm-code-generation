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
        for (int i = currentIndex; i < visited.length; i++) {
            if (!visited[i]) {
                currentIndex = i + 1;
                return i;
            }
        }
        throw new NoSuchElementException("No more unvisited vertices");
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported");
    }
}