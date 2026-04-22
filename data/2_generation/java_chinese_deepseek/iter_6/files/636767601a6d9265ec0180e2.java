import java.util.*;

class Pair<K, V> {
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

    @Override
    public String toString() {
        return "Pair{" + "key=" + key + ", value=" + value + '}';
    }
}

public class GraphSeparator {

    private List<Pair<List<Pair<Integer, Integer>>, Integer>> computeGlobalSeparatorList(Map<Integer, List<Integer>> graph) {
        List<Pair<List<Pair<Integer, Integer>>, Integer>> globalSeparatorList = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int u = entry.getKey();
            for (int v : entry.getValue()) {
                List<Pair<Integer, Integer>> separatorList = computeMinSeparatorForEdge(graph, u, v);
                globalSeparatorList.add(new Pair<>(separatorList, v));
            }
        }

        return globalSeparatorList;
    }

    private List<Pair<Integer, Integer>> computeMinSeparatorForEdge(Map<Integer, List<Integer>> graph, int u, int v) {
        List<Pair<Integer, Integer>> separatorList = new ArrayList<>();

        // 假设我们使用简单的启发式方法来计算最小分隔符
        // 这里我们假设最小分隔符是边的两个端点
        separatorList.add(new Pair<>(u, v));

        return separatorList;
    }

    public static void main(String[] args) {
        GraphSeparator graphSeparator = new GraphSeparator();

        // 示例图
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 3));
        graph.put(3, Arrays.asList(1, 2, 4));
        graph.put(4, Arrays.asList(3));

        List<Pair<List<Pair<Integer, Integer>>, Integer>> result = graphSeparator.computeGlobalSeparatorList(graph);

        for (Pair<List<Pair<Integer, Integer>>, Integer> pair : result) {
            System.out.println("Edge: " + pair.getValue() + ", Separator List: " + pair.getKey());
        }
    }
}