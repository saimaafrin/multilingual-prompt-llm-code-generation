import java.util.*;

class Bucket {
    private String name;
    private List<Bucket> children;

    public Bucket(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Bucket child) {
        this.children.add(child);
    }

    public void removeSelf() {
        // Remove all children first
        for (Bucket child : children) {
            child.removeSelf();
        }
        // Clear the children list
        children.clear();
        // Remove this bucket from its parent (if any)
        // Assuming there is a parent reference, but since it's not provided, we'll assume it's handled externally.
        // For example, if the parent has a list of children, this bucket should be removed from that list.
        // This is a placeholder for the actual removal logic.
        System.out.println("Bucket " + name + " has been removed.");
    }

    public static void main(String[] args) {
        Bucket root = new Bucket("root");
        Bucket child1 = new Bucket("child1");
        Bucket child2 = new Bucket("child2");

        root.addChild(child1);
        root.addChild(child2);

        // Remove child1
        child1.removeSelf();
    }
}