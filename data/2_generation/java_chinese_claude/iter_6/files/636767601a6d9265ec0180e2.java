import java.util.*;
import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.util.Pair;

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
            
            // 创建临时图用于查找分隔符
            Graph<V,E> tempGraph = (Graph<V,E>)graph.clone();
            tempGraph.removeEdge(edge);
            
            // 获取源点和目标点的邻接点
            Set<V> sourceNeighbors = new HashSet<>(graph.neighborsOf(source));
            Set<V> targetNeighbors = new HashSet<>(graph.neighborsOf(target));
            
            // 计算最小分隔符
            List<Pair<Integer,Integer>> separators = new ArrayList<>();
            ConnectivityInspector<V,E> inspector = new ConnectivityInspector<>(tempGraph);
            
            // 检查每对顶点之间的连通性
            for (V s : sourceNeighbors) {
                for (V t : targetNeighbors) {
                    if (!inspector.pathExists(s, t)) {
                        // 找到一个分隔符
                        separators.add(new Pair<>(
                            graph.vertexSet().indexOf(s),
                            graph.vertexSet().indexOf(t)
                        ));
                    }
                }
            }
            
            // 将该边的分隔符列表添加到全局列表中
            if (!separators.isEmpty()) {
                globalSeparators.add(new Pair<>(separators, edge));
            }
        }
        
        return globalSeparators;
    }
}