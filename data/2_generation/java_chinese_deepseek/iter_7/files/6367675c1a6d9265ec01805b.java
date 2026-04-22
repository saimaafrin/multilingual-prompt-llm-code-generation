import java.util.*;

public class Tree {
    private Map<Integer, List<Integer>> edgeList;

    public Tree() {
        edgeList = new HashMap<>();
    }

    public void addEdge(int from, int to) {
        edgeList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        edgeList.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
    }

    public void removeFromTreeEdgeList(int from, int to) {
        if (edgeList.containsKey(from)) {
            edgeList.get(from).removeIf(node -> node == to);
        }
        if (edgeList.containsKey(to)) {
            edgeList.get(to).removeIf(node -> node == from);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addEdge(1, 2);
        tree.addEdge(2, 3);
        tree.addEdge(3, 4);

        System.out.println("Before removal: " + tree.edgeList);
        tree.removeFromTreeEdgeList(2, 3);
        System.out.println("After removal: " + tree.edgeList);
    }
}