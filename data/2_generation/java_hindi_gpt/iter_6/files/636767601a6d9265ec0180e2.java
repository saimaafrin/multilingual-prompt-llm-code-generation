import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph {
    private List<Pair<Integer, Integer>> vertices;
    private List<Edge> edges;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(int x, int y) {
        vertices.add(new Pair<>(x, y));
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    private List<Pair<List<Pair<Integer, Integer>>, Edge>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer, Integer>>, Edge>> globalSeparators = new ArrayList<>();

        for (Edge edge : edges) {
            List<Pair<Integer, Integer>> separators = findMinSeparators(edge);
            globalSeparators.add(new Pair<>(separators, edge));
        }

        return globalSeparators;
    }

    private List<Pair<Integer, Integer>> findMinSeparators(Edge edge) {
        // Placeholder for actual logic to find minimum separators for the given edge
        List<Pair<Integer, Integer>> separators = new ArrayList<>();
        // Add logic to compute minimum separators based on the edge
        return separators;
    }

    // Pair class to hold two values
    public static class Pair<K, V> {
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
    }

    // Edge class to represent an edge in the graph
    public static class Edge {
        private int start;
        private int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}