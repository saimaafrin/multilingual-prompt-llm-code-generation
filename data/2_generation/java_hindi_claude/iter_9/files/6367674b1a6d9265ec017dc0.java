import java.util.*;

public class Graph {
    // Assuming we have an adjacency list representation of the graph
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    /**
     * Compute all vertices that have positive degree by iterating over the edges on purpose. 
     * This keeps the complexity to O(m) where m is the number of edges.
     * @return set of vertices with positive degree
     */
    public Set<Integer> getVerticesWithPositiveDegree() {
        Set<Integer> verticesWithDegree = new HashSet<>();
        
        // Iterate through all edges in adjacency list
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            int vertex = entry.getKey();
            List<Integer> neighbors = entry.getValue();
            
            // If vertex has any neighbors, add it to result set
            if (!neighbors.isEmpty()) {
                verticesWithDegree.add(vertex);
            }
            
            // Add all neighbors to result set since they must have positive degree
            verticesWithDegree.addAll(neighbors);
        }
        
        return verticesWithDegree;
    }
}