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
                    globalSeparatorList.add(new Pair<>(separators, u));
                    globalSeparatorList.add(new Pair<>(separators, v));
                }
            }
        }

        return globalSeparatorList;
    }

    private List<Pair<Integer, Integer>> findMinimalSeparators(int u, int v) {
        List<Pair<Integer, Integer>> separators = new ArrayList<>();

        // Find all common neighbors of u and v
        Set<Integer> commonNeighbors = new HashSet<>(adjacencyList.get(u));
        commonNeighbors.retainAll(adjacencyList.get(v));

        // For each common neighbor, check if it is a separator
        for (int w : commonNeighbors) {
            if (isSeparator(u, v, w)) {
                separators.add(new Pair<>(u, w));
                separators.add(new Pair<>(v, w));
            }
        }

        return separators;
    }

    private boolean isSeparator(int u, int v, int w) {
        // Remove w from the graph and check if u and v are still connected
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited.add(u);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjacencyList.get(current)) {
                if (neighbor == w) continue;
                if (neighbor == v) return false;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        List<Pair<List<Pair<Integer, Integer>>, Integer>> result = graph.computeGlobalSeparatorList();
        for (Pair<List<Pair<Integer, Integer>>, Integer> pair : result) {
            System.out.println("Edge: " + pair.getSecond());
            System.out.println("Separators: " + pair.getFirst());
        }
    }
}

class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}