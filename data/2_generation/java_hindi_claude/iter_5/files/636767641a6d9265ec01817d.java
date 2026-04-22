import java.util.*;

public class BipartiteGraph {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list representation

    /**
     * Construct a complete bipartite graph
     * @param m Number of vertices in first partition
     * @param n Number of vertices in second partition
     * @return Adjacency list representation of complete bipartite graph
     */
    public List<List<Integer>> constructBipartiteGraph(int m, int n) {
        // Total vertices is sum of both partitions
        V = m + n;
        
        // Initialize adjacency list
        adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Connect each vertex in first partition to all vertices in second partition
        for(int i = 0; i < m; i++) {
            for(int j = m; j < V; j++) {
                // Add edges in both directions
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
        }
        
        return adj;
    }
}