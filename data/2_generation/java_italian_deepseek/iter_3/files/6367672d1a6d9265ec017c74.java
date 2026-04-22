import java.util.HashSet;
import java.util.Set;

public class MySet {
    private Set<Integer> set;

    public MySet() {
        set = new HashSet<>();
    }

    /**
     * Rimuove un valore dal set. Restituisce true se il set conteneva l'elemento specificato.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }
}