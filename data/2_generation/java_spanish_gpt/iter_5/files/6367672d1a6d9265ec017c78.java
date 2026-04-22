import java.util.HashSet;

public class MySet {
    private HashSet<Integer> set;

    public MySet() {
        set = new HashSet<>();
    }

    /** 
     * Inserta un valor en el conjunto. Devuelve verdadero si el conjunto no contenía ya el elemento especificado. 
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    public static void main(String[] args) {
        MySet mySet = new MySet();
        System.out.println(mySet.insert(5)); // true
        System.out.println(mySet.insert(5)); // false
    }
}