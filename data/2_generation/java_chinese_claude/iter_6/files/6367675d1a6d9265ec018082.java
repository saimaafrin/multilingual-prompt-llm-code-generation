import java.util.*;

public class Graph {
    private class Node {
        int id;
        boolean isVirtual;
        Node realNode; // 对应的真实节点
        List<Edge> edges;
        
        Node(int id) {
            this.id = id;
            this.isVirtual = false;
            this.edges = new ArrayList<>();
        }
    }

    private class Edge {
        Node source;
        Node target;
        int weight;
        
        Edge(Node source, Node target) {
            this.source = source;
            this.target = target;
            this.weight = 1;
        }
    }

    private Node currentNode;
    private Node nextNode;

    public Edge edgeToNext() {
        if (currentNode == null || nextNode == null) {
            return null;
        }

        // 获取实际的源节点和目标节点
        Node actualSource = currentNode.isVirtual ? currentNode.realNode : currentNode;
        Node actualTarget = nextNode.isVirtual ? nextNode.realNode : nextNode;

        // 在源节点的边列表中查找连接到目标节点的边
        for (Edge edge : actualSource.edges) {
            if (edge.target == actualTarget) {
                return edge;
            }
        }

        // 如果没有找到边，创建一个新的边
        Edge newEdge = new Edge(actualSource, actualTarget);
        actualSource.edges.add(newEdge);
        return newEdge;
    }
}