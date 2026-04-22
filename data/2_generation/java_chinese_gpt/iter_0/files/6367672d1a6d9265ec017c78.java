import java.util.HashSet;

public class MySet {
    private HashSet<Integer> set;

    public MySet() {
        set = new HashSet<>();
    }

    /** 
     * 将一个值插入集合。如果集合中尚未包含指定元素，则返回真。
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    public static void main(String[] args) {
        MySet mySet = new MySet();
        System.out.println(mySet.insert(1)); // true
        System.out.println(mySet.insert(1)); // false
        System.out.println(mySet.insert(2)); // true
    }
}