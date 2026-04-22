import java.util.*;

class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private List<Pair<List<Pair<Integer, Integer>>, Integer>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer, Integer>>, Integer>> globalSeparators = new ArrayList<>();

        // Iterate over all edges
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                if (u < v) { // Ensure each edge is processed only once
                    List<Pair<Integer, Integer>> separators = findMinimalSeparators(u, v);
                    globalSeparators.add(new Pair<>(separators, new Pair<>(u, v)));
                }
            }
        }

        return globalSeparators;
    }

    private List<Pair<Integer, Integer>> findMinimalSeparators(int u, int v) {
        List<Pair<Integer, Integer>> separators = new ArrayList<>();

        // Temporarily remove the edge (u, v)
        adj.get(u).remove((Integer) v);
        adj.get(v).remove((Integer) u);

        // Find all minimal separators between u and v
        // This is a placeholder for a more complex algorithm
        // For simplicity, we assume that the minimal separators are the common neighbors of u and v
        Set<Integer> commonNeighbors = new HashSet<>(adj.get(u));
        commonNeighbors.retainAll(adj.get(v));

        for (int neighbor : commonNeighbors) {
            separators.add(new Pair<>(u, neighbor));
            separators.add(new Pair<>(v, neighbor));
        }

        // Restore the edge (u, v)
        adj.get(u).add(v);
        adj.get(v).add(u);

        return separators;
    }

    // Helper class to represent a pair of values
    class Pair<A, B> {
        A first;
        B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
}