import java.util.Set;
import org.jgrapht.Graph;

public class GraphUtils {

    /** 
     * जांचें कि <code>graph</code> द्वारा दिए गए <code>vertices</code> से प्रेरित उपग्राफ पूर्ण है, अर्थात् एक क्लिक है।
     * @param graph ग्राफ।
     * @param vertices उपग्राफ को प्रेरित करने के लिए वर्टिस।
     * @return यदि प्रेरित उपग्राफ एक क्लिक है तो true।
     */
    private static <V,E> boolean isClique(Graph<V,E> graph, Set<V> vertices) {
        if (vertices.size() < 2) {
            return true; // A single vertex or empty set is trivially a clique
        }

        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    return false; // If there is no edge between any two vertices, it's not a clique
                }
            }
        }
        return true; // All pairs of vertices are connected
    }
}