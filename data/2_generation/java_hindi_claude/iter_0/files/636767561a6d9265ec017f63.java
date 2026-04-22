import java.util.*;

public class Graph {
    private boolean[] visited;

    /**
     * Checks whether there exist unvisited vertices.
     * @return true if there exist unvisited vertices.
     */
    public boolean hasUnvisitedVertices() {
        for (boolean v : visited) {
            if (!v) {
                return true;
            }
        }
        return false;
    }
}