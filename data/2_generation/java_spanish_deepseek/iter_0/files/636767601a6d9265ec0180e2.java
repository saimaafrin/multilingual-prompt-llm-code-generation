import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class GraphSeparator {

    // Assuming the graph is represented as an adjacency list
    private List<List<Integer>> graph;

    public GraphSeparator(List<List<Integer>> graph) {
        this.graph = graph;
    }

    private List<Pair<List<Pair<Integer, Integer>>, Integer>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer, Integer>>, Integer>> globalSeparators = new ArrayList<>();

        // Iterate over each vertex in the graph
        for (int u = 0; u < graph.size(); u++) {
            // Iterate over each neighbor of the current vertex
            for (int v : graph.get(u)) {
                if (u < v) { // Ensure each edge is processed only once
                    // Compute the minimal separators for the neighborhood of edge (u, v)
                    List<Pair<Integer, Integer>> separators = computeMinimalSeparators(u, v);

                    // Add the separators to the global list
                    globalSeparators.add(new Pair<>(separators, u));
                }
            }
        }

        return globalSeparators;
    }

    private List<Pair<Integer, Integer>> computeMinimalSeparators(int u, int v) {
        List<Pair<Integer, Integer>> separators = new ArrayList<>();

        // Get the neighborhood of edge (u, v)
        Set<Integer> neighborhood = new HashSet<>();
        neighborhood.addAll(graph.get(u));
        neighborhood.addAll(graph.get(v));
        neighborhood.remove(u);
        neighborhood.remove(v);

        // For each pair of nodes in the neighborhood, check if they are connected
        for (int x : neighborhood) {
            for (int y : neighborhood) {
                if (x < y && !graph.get(x).contains(y)) {
                    // If they are not connected, add the pair as a separator
                    separators.add(new Pair<>(x, y));
                }
            }
        }

        return separators;
    }

    // Pair class to hold pairs of elements
    public static class Pair<A, B> {
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
    }

    public static void main(String[] args) {
        // Example usage
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(List.of(1, 2));
        graph.add(List.of(0, 2, 3));
        graph.add(List.of(0, 1, 3));
        graph.add(List.of(1, 2));

        GraphSeparator separator = new GraphSeparator(graph);
        List<Pair<List<Pair<Integer, Integer>>, Integer>> result = separator.computeGlobalSeparatorList();

        // Print the result
        for (Pair<List<Pair<Integer, Integer>>, Integer> pair : result) {
            System.out.println("Edge: " + pair.getSecond());
            for (Pair<Integer, Integer> sep : pair.getFirst()) {
                System.out.println("Separator: (" + sep.getFirst() + ", " + sep.getSecond() + ")");
            }
        }
    }
}