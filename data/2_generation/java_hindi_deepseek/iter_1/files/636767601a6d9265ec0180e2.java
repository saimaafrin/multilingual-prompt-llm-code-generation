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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

public class Graph {
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

        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int u = entry.getKey();
            for (int v : entry.getValue()) {
                if (u < v) { // To avoid processing the same edge twice
                    List<Pair<Integer, Integer>> separators = findMinimalSeparators(u, v);
                    globalSeparatorList.add(new Pair<>(separators, u));
                    globalSeparatorList.add(new Pair<>(separators, v));
                }
            }
        }

        return globalSeparatorList;
    }

    private List<Pair<Integer, Integer>> findMinimalSeparators(int u, int v) {
        // Placeholder for the actual algorithm to find minimal separators
        // This is a simplified version that just returns the edge itself as a separator
        List<Pair<Integer, Integer>> separators = new ArrayList<>();
        separators.add(new Pair<>(u, v));
        return separators;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        List<Pair<List<Pair<Integer, Integer>>, Integer>> result = graph.computeGlobalSeparatorList();
        for (Pair<List<Pair<Integer, Integer>>, Integer> pair : result) {
            System.out.println("Edge: " + pair.getValue());
            System.out.println("Separators: " + pair.getKey());
        }
    }
}