import java.util.HashSet;
import java.util.Set;

public class CollectionRemover {
    private Set<Integer> collection;

    public CollectionRemover() {
        this.collection = new HashSet<>();
    }

    public boolean remove(int val) {
        return this.collection.remove(val);
    }

    public void add(int val) {
        this.collection.add(val);
    }

    public static void main(String[] args) {
        CollectionRemover remover = new CollectionRemover();
        remover.add(10);
        remover.add(20);
        remover.add(30);

        System.out.println(remover.remove(20)); // 输出: true
        System.out.println(remover.remove(40)); // 输出: false
    }
}