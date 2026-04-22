import java.util.*;

public class Tree {
    private Map<Integer, List<Integer>> edgeList;

    public Tree() {
        edgeList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        edgeList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        edgeList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public void removeFromTreeEdgeList(int u, int v) {
        if (edgeList.containsKey(u)) {
            edgeList.get(u).removeIf(node -> node == v);
        }
        if (edgeList.containsKey(v)) {
            edgeList.get(v).removeIf(node -> node == u);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addEdge(1, 2);
        tree.addEdge(2, 3);
        tree.addEdge(3, 4);

        System.out.println("Before removal:");
        System.out.println(tree.edgeList);

        tree.removeFromTreeEdgeList(2, 3);

        System.out.println("After removal:");
        System.out.println(tree.edgeList);
    }
}