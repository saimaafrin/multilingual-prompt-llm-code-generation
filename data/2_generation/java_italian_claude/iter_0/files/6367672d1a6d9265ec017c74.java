import java.util.HashSet;

public class IntegerSet {
    private HashSet<Integer> set;

    public IntegerSet() {
        set = new HashSet<>();
    }

    /**
     * Rimuove un valore dal set. Restituisce true se il set conteneva l'elemento specificato.
     */
    public boolean remove(int val) {
        return set.remove(Integer.valueOf(val));
    }
}