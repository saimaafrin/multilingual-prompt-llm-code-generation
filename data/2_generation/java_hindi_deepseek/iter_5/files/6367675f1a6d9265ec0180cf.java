import org.jgrapht.Graph;
import java.util.Set;

public class CliqueChecker {

    /**
     * जांचें कि <code>graph</code> द्वारा दिए गए <code>vertices</code> से प्रेरित उपग्राफ पूर्ण है, अर्थात् एक क्लिक है।
     * @param graph ग्राफ।
     * @param vertices उपग्राफ को प्रेरित करने के लिए वर्टिस।
     * @return यदि प्रेरित उपग्राफ एक क्लिक है तो true।
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        // Check if every pair of vertices in the set is connected by an edge
        for (V u : vertices) {
            for (V v : vertices) {
                if (!u.equals(v) && !graph.containsEdge(u, v)) {
                    return false;
                }
            }
        }
        return true;
    }
}