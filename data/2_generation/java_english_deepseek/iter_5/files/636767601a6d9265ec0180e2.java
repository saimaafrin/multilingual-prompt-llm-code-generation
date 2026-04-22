import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class GraphSeparator {

    // Assuming the graph is represented as a list of edges and vertices
    private List<Pair<Integer, Integer>> edges;
    private Set<Integer> vertices;

    public GraphSeparator(List<Pair<Integer, Integer>> edges, Set<Integer> vertices) {
        this.edges = edges;
        this.vertices = vertices;
    }

    /**
     * Computes the global separator list of the {@code graph}. More precisely, for every edge $e$ in the $G = (V, E)$ computes list of minimal separators $S_e$ in the neighborhood of $e$ and then concatenates these lists. Note: the result may contain duplicates
     * @return the list of minimal separators of every edge $e$ in the inspected graph
     */
    private List<Pair<List<Pair<Integer, Integer>>, Pair<Integer, Integer>>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer, Integer>>, Pair<Integer, Integer>>> globalSeparatorList = new ArrayList<>();

        for (Pair<Integer, Integer> edge : edges) {
            List<Pair<Integer, Integer>> separators = computeMinimalSeparatorsForEdge(edge);
            globalSeparatorList.add(new Pair<>(separators, edge));
        }

        return globalSeparatorList;
    }

    private List<Pair<Integer, Integer>> computeMinimalSeparatorsForEdge(Pair<Integer, Integer> edge) {
        List<Pair<Integer, Integer>> separators = new ArrayList<>();

        // Get the vertices of the edge
        int u = edge.getFirst();
        int v = edge.getSecond();

        // Find the neighborhood of the edge
        Set<Integer> neighborhood = new HashSet<>();
        for (Pair<Integer, Integer> e : edges) {
            if (e.getFirst() == u || e.getFirst() == v || e.getSecond() == u || e.getSecond() == v) {
                neighborhood.add(e.getFirst());
                neighborhood.add(e.getSecond());
            }
        }

        // Remove the edge vertices themselves
        neighborhood.remove(u);
        neighborhood.remove(v);

        // Convert the neighborhood to a list of pairs (assuming minimal separators are pairs of vertices)
        for (int vertex : neighborhood) {
            separators.add(new Pair<>(u, vertex));
            separators.add(new Pair<>(v, vertex));
        }

        return separators;
    }

    // Assuming Pair class is defined as follows:
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
}