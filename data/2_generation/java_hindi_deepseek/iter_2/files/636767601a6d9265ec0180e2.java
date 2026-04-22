import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjacencyList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    private List<Pair<List<Pair<Integer, Integer>>, Integer>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer, Integer>>, Integer>> globalSeparatorList = new ArrayList<>();

        // Iterate over all edges in the graph
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int u = entry.getKey();
            for (int v : entry.getValue()) {
                if (u < v) { // Ensure each edge is processed only once
                    List<Pair<Integer, Integer>> separators = findMinimalSeparators(u, v);
                    globalSeparatorList.add(new Pair<>(separators, new Pair<>(u, v)));
                }
            }
        }

        return globalSeparatorList;
    }

    private List<Pair<Integer, Integer>> findMinimalSeparators(int u, int v) {
        // Placeholder for actual implementation of finding minimal separators
        // This is a complex problem and typically involves advanced graph algorithms
        // such as BFS, DFS, or flow-based methods.
        List<Pair<Integer, Integer>> separators = new ArrayList<>();
        // Example: Add some dummy separators for illustration
        separators.add(new Pair<>(u, v));
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

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        List<Pair<List<Pair<Integer, Integer>>, Integer>> result = graph.computeGlobalSeparatorList();
        for (Pair<List<Pair<Integer, Integer>>, Integer> pair : result) {
            System.out.println("Edge: " + pair.second);
            System.out.println("Separators: " + pair.first);
        }
    }
}