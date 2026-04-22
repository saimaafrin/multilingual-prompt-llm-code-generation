import java.util.HashSet;

public class CustomSet {
    private HashSet<Integer> set;

    public CustomSet() {
        set = new HashSet<>();
    }

    /** 
     * Elimina un valor del conjunto. Devuelve verdadero si el conjunto contenía el elemento especificado. 
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