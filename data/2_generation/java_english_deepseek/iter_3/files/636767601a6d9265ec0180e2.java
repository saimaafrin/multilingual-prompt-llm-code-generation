import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class GraphSeparator {

    private static class Pair<K, V> {
        private final K key;
        private final V value;

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

    private static class Edge {
        private final int u;
        private final int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        public int getU() {
            return u;
        }

        public int getV() {
            return v;
        }
    }

    private Map<Integer, Set<Integer>> adjacencyList;

    public GraphSeparator(Map<Integer, Set<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    private List<Pair<List<Pair<Integer, Integer>>, Edge>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer, Integer>>, Edge>> globalSeparatorList = new ArrayList<>();

        for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
            int u = entry.getKey();
            for (int v : entry.getValue()) {
                Edge edge = new Edge(u, v);
                List<Pair<Integer, Integer>> separators = computeMinimalSeparatorsForEdge(u, v);
                globalSeparatorList.add(new Pair<>(separators, edge));
            }
        }

        return globalSeparatorList;
    }

    private List<Pair<Integer, Integer>> computeMinimalSeparatorsForEdge(int u, int v) {
        List<Pair<Integer, Integer>> separators = new ArrayList<>();

        Set<Integer> neighborhoodU = adjacencyList.get(u);
        Set<Integer> neighborhoodV = adjacencyList.get(v);

        Set<Integer> commonNeighbors = new HashSet<>(neighborhoodU);
        commonNeighbors.retainAll(neighborhoodV);

        for (int neighbor : commonNeighbors) {
            separators.add(new Pair<>(u, neighbor));
            separators.add(new Pair<>(v, neighbor));
        }

        return separators;
    }

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(1, Set.of(2, 3));
        adjacencyList.put(2, Set.of(1, 3, 4));
        adjacencyList.put(3, Set.of(1, 2, 4));
        adjacencyList.put(4, Set.of(2, 3));

        GraphSeparator graphSeparator = new GraphSeparator(adjacencyList);
        List<Pair<List<Pair<Integer, Integer>>, Edge>> result = graphSeparator.computeGlobalSeparatorList();

        for (Pair<List<Pair<Integer, Integer>>, Edge> pair : result) {
            System.out.println("Edge: (" + pair.getValue().getU() + ", " + pair.getValue().getV() + ")");
            System.out.println("Separators: " + pair.getKey());
        }
    }
}