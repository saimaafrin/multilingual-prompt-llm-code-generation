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
        List<Pair<List<Pair<Integer, Integer>>, Integer>> globalSeparators = new ArrayList<>();

        // Iterate over all edges in the graph
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int u = entry.getKey();
            for (int v : entry.getValue()) {
                if (u < v) { // Ensure each edge is processed only once
                    List<Pair<Integer, Integer>> separators = findMinimalSeparators(u, v);
                    globalSeparators.add(new Pair<>(separators, new Pair<>(u, v)));
                }
            }
        }

        return globalSeparators;
    }

    private List<Pair<Integer, Integer>> findMinimalSeparators(int u, int v) {
        // This is a placeholder for the actual algorithm to find minimal separators
        // between nodes u and v. The actual implementation would depend on the specific
        // graph structure and the algorithm used (e.g., BFS, DFS, etc.).
        List<Pair<Integer, Integer>> separators = new ArrayList<>();
        // Example: Add a dummy separator
        separators.add(new Pair<>(u, v));
        return separators;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        List<Pair<List<Pair<Integer, Integer>>, Integer>> globalSeparators = graph.computeGlobalSeparatorList();
        for (Pair<List<Pair<Integer, Integer>>, Integer> separator : globalSeparators) {
            System.out.println("Edge: " + separator.getSecond());
            System.out.println("Separators: " + separator.getFirst());
        }
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}