import java.util.*;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" + key + ", " + value + '}';
    }
}

public class Graph {
    private List<Pair<List<Pair<Integer, Integer>>, Integer>> computeGlobalSeparatorList() {
        // Placeholder for the graph's adjacency list or edge list
        // Assuming the graph is represented as a list of edges
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        // Example edges: (1, 2), (2, 3), (3, 4)
        edges.add(new Pair<>(1, 2));
        edges.add(new Pair<>(2, 3));
        edges.add(new Pair<>(3, 4));

        // Placeholder for the result
        List<Pair<List<Pair<Integer, Integer>>, Integer>> globalSeparatorList = new ArrayList<>();

        // For each edge, compute the minimal separators in its neighborhood
        for (Pair<Integer, Integer> edge : edges) {
            // Placeholder for the minimal separators of the current edge
            List<Pair<Integer, Integer>> separators = new ArrayList<>();

            // Example: Adding some dummy separators
            separators.add(new Pair<>(1, 3));
            separators.add(new Pair<>(2, 4));

            // Add the separators for the current edge to the global list
            globalSeparatorList.add(new Pair<>(separators, edge.getValue()));
        }

        return globalSeparatorList;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        List<Pair<List<Pair<Integer, Integer>>, Integer>> result = graph.computeGlobalSeparatorList();
        System.out.println(result);
    }
}