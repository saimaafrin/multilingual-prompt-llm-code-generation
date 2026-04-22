import java.util.*;

public class Tree {
    private Map<Integer, List<Integer>> adjacencyList;

    public Tree() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }

    public void removeFromTreeEdgeList(int source, int destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).removeIf(node -> node == destination);
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).removeIf(node -> node == source);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addEdge(1, 2);
        tree.addEdge(2, 3);
        tree.addEdge(3, 4);

        System.out.println("Before removal:");
        System.out.println(tree.adjacencyList);

        tree.removeFromTreeEdgeList(2, 3);

        System.out.println("After removal:");
        System.out.println(tree.adjacencyList);
    }
}