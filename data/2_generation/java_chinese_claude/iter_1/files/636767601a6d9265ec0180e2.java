import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.interfaces.MinimumSTCutAlgorithm;
import org.jgrapht.alg.flow.EdmondsKarpMFImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.Pair;

import java.util.*;

public class SeparatorFinder<V,E> {

    private Graph<V,E> graph;
    
    public SeparatorFinder(Graph<V,E> g) {
        this.graph = g;
    }

    /**
     * 计算图 {@code graph} 的全局分隔符列表。更准确地说，对于图 $G = (V, E)$ 中的每条边 $e$，计算边 $e$ 邻域中的最小分隔符列表 $S_e$，然后将这些列表连接起来。注意：结果可能包含重复项。
     * @return 被检查图中每条边 $e$ 的最小分隔符列表
     */
    private List<Pair<List<Pair<Integer,Integer>>,E>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer,Integer>>,E>> globalSeparators = new ArrayList<>();
        
        // 遍历图中的每条边
        for (E edge : graph.edgeSet()) {
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            
            // 创建一个新图，不包含当前边
            Graph<V,E> subgraph = new SimpleGraph<>(graph.getEdgeFactory());
            for (V vertex : graph.vertexSet()) {
                subgraph.addVertex(vertex);
            }
            for (E e : graph.edgeSet()) {
                if (!e.equals(edge)) {
                    subgraph.addEdge(graph.getEdgeSource(e), graph.getEdgeTarget(e));
                }
            }
            
            // 计算最小割
            MinimumSTCutAlgorithm<V,E> minCutAlg = new EdmondsKarpMFImpl<>(subgraph);
            double minCut = minCutAlg.calculateMinCut(source, target);
            
            // 如果存在分隔符
            if (minCut < Double.POSITIVE_INFINITY) {
                Set<V> sourcePartition = minCutAlg.getSourcePartition();
                Set<V> targetPartition = minCutAlg.getSinkPartition();
                
                // 构建分隔符对列表
                List<Pair<Integer,Integer>> separatorPairs = new ArrayList<>();
                for (V v1 : sourcePartition) {
                    for (V v2 : targetPartition) {
                        if (graph.containsEdge(v1, v2)) {
                            separatorPairs.add(new Pair<>(
                                graph.vertexSet().stream().toList().indexOf(v1),
                                graph.vertexSet().stream().toList().indexOf(v2)
                            ));
                        }
                    }
                }
                
                globalSeparators.add(new Pair<>(separatorPairs, edge));
            }
        }
        
        return globalSeparators;
    }
}