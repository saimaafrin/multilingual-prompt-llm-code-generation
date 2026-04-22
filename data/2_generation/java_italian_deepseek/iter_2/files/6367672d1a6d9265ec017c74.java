import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        this.set = new HashSet<>();
    }

    /**
     * Rimuove un valore dal set. Restituisce true se il set conteneva l'elemento specificato.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    // Optional: Method to add elements to the set for testing
    public void add(int val) {
        set.add(val);
    }

    // Optional: Method to check if the set contains an element
    public boolean contains(int val) {
        return set.contains(val);
    }
}