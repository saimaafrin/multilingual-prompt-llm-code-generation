import java.util.HashSet;

public class CustomSet {
    private HashSet<Integer> set;

    public CustomSet() {
        set = new HashSet<>();
    }

    /** 
     * Removes a value from the set. Returns true if the set contained the specified element. 
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    public void add(int val) {
        set.add(val);
    }

    public boolean contains(int val) {
        return set.contains(val);
    }

    public static void main(String[] args) {
        CustomSet customSet = new CustomSet();
        customSet.add(1);
        customSet.add(2);
        System.out.println(customSet.remove(1)); // true
        System.out.println(customSet.remove(3)); // false
    }
}