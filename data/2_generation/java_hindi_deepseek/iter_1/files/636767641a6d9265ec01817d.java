import java.util.Map;
import java.util.HashMap;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class CompleteBipartiteGraphGenerator<V, E> {

    /**
     * एक पूर्ण द्विभाजित ग्राफ का निर्माण करें
     * 
     * @param target    ग्राफ जिसमें द्विभाजित ग्राफ जोड़ा जाएगा
     * @param resultMap ग्राफ के शीर्षों को मैप करने के लिए एक मैप
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Assuming the graph is bipartitioned into two sets, setA and setB
        Map<String, V> setA = new HashMap<>();
        Map<String, V> setB = new HashMap<>();

        // Add vertices to setA and setB
        for (Map.Entry<String, V> entry : resultMap.entrySet()) {
            String key = entry.getKey();
            V vertex = entry.getValue();
            if (key.startsWith("A")) {
                setA.put(key, vertex);
                target.addVertex(vertex);
            } else if (key.startsWith("B")) {
                setB.put(key, vertex);
                target.addVertex(vertex);
            }
        }

        // Add edges between all vertices in setA and setB
        for (V vertexA : setA.values()) {
            for (V vertexB : setB.values()) {
                target.addEdge(vertexA, vertexB);
            }
        }
    }
}