import java.util.*;

class Pair<A, B> {
    public final A first;
    public final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
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
        List<Pair<List<Pair<Integer, Integer>>, Integer>> globalSeparators = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int u = entry.getKey();
            for (int v : entry.getValue()) {
                if (u < v) { // Avoid processing the same edge twice
                    List<Pair<Integer, Integer>> separators = computeMinimalSeparators(u, v);
                    globalSeparators.add(new Pair<>(separators, u));
                }
            }
        }

        return globalSeparators;
    }

    private List<Pair<Integer, Integer>> computeMinimalSeparators(int u, int v) {
        List<Pair<Integer, Integer>> separators = new ArrayList<>();

        // Example logic to compute minimal separators in the neighborhood of edge (u, v)
        // This is a placeholder and should be replaced with actual logic
        List<Integer> neighborsU = adjacencyList.get(u);
        List<Integer> neighborsV = adjacencyList.get(v);

        for (int neighborU : neighborsU) {
            for (int neighborV : neighborsV) {
                if (neighborU != neighborV) {
                    separators.add(new Pair<>(neighborU, neighborV));
                }
            }
        }

        return separators;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        List<Pair<List<Pair<Integer, Integer>>, Integer>> globalSeparators = graph.computeGlobalSeparatorList();
        for (Pair<List<Pair<Integer, Integer>>, Integer> pair : globalSeparators) {
            System.out.println("Edge: " + pair.second);
            for (Pair<Integer, Integer> separator : pair.first) {
                System.out.println("  Separator: (" + separator.first + ", " + separator.second + ")");
            }
        }
    }
}