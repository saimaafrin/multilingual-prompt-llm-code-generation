import java.util.HashSet;

public class CustomSet {
    private HashSet<Integer> set;

    public CustomSet() {
        set = new HashSet<>();
    }

    /** 
     * Inserts a value to the set. Returns true if the set did not already contain the specified element. 
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    public static void main(String[] args) {
        CustomSet customSet = new CustomSet();
        System.out.println(customSet.insert(1)); // true
        System.out.println(customSet.insert(1)); // false
        System.out.println(customSet.insert(2)); // true
    }
}